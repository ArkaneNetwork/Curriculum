package be.eurofins.vechain.vechain;

import network.arkane.provider.secret.generation.VechainSecretKey;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

public class VechainStressTest implements JavaSamplerClient {

    private TransactionService transactionService = new TransactionService();
    private VechainSecretKey vechainSecretKey;

    @Override
    public void setupTest(JavaSamplerContext javaSamplerContext) {
        //load wallet
        String pk = javaSamplerContext.getParameter("pk");
        vechainSecretKey = transactionService.loadWallet(pk);
    }

    @Override
    public SampleResult runTest(JavaSamplerContext javaSamplerContext) {
        SampleResult result = new SampleResult();
        result.sampleStart();
        result.setSampleLabel("Vechain Test Sample");
        try {
            SubmissionResult submittedTx = transactionService.executeTransaction(vechainSecretKey);
            ReceiptResult status = transactionService.getReceipt(submittedTx);
            while (status == null) {
                Thread.sleep(100);
                status = transactionService.getReceipt(submittedTx);
            }
            result.sampleEnd();
            result.setResponseCode("200");
            result.setResponseMessage(submittedTx.getId());
            result.setSuccessful(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.sampleEnd();
            result.setResponseCode("500");
            result.setResponseMessage(e.getMessage());
            result.setSuccessful(false);
        }
        return result;
    }

    @Override
    public void teardownTest(JavaSamplerContext javaSamplerContext) {

    }

    @Override
    public Arguments getDefaultParameters() {
        Arguments defaultParameters = new Arguments();
        defaultParameters.addArgument("pk", "0x...");
        return defaultParameters;
    }

}
