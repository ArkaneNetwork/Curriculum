package be.eurofins.vechain.vechain;

import network.arkane.provider.sign.VechainTransactionSigner;

public class TransactionTest {

    private final VechainTransactionSigner signer;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Running me should sign + submit a transaction ");
        new TransactionTest().transact();

    }

    public TransactionTest() {
        signer = new VechainTransactionSigner();
    }

    public void transact() throws InterruptedException {
        Object key = loadWallet("<your_private_key>");
        System.out.println(key);

        Object signedTransaction = generateTransaction(key);
        System.out.println(key);

        Object submittedTransaction = submitTransaction(signedTransaction);
        System.out.println(key);

        //wait for mining
        System.out.println("Waiting for transaction to be mined...");
        Thread.sleep(10000);

        Object status = getStatus(submittedTransaction);
        System.out.println(status);

        Object receipt = getReceipt(submittedTransaction);
        System.out.println(receipt);
    }

    private Object loadWallet(String privateKey) {
        return null;
    }

    public Object generateTransaction(Object secretKey) {
        return null;
    }

    private Object submitTransaction(Object signedTransaction) {
        return null;
    }

    private Object getStatus(Object submittedTransaction) {
        return null;
    }

    private Object getReceipt(Object submittedTransaction) {
        return null;
    }
}
