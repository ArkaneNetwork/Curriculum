package be.eurofins.vechain.vechain;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

public class VechainStressTest implements JavaSamplerClient {

    private TransactionService transactionService = new TransactionService();

    @Override
    public void setupTest(JavaSamplerContext javaSamplerContext) {
        //load wallet

    }

    @Override
    public SampleResult runTest(JavaSamplerContext javaSamplerContext) {
        //submit transaction
        //"wait" for receipt
        //return successful or error
        return null;
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
