package be.eurofins.vechain.vechain;

import network.arkane.provider.secret.generation.VechainSecretKey;
import network.arkane.provider.sign.VechainTransactionSignable;
import network.arkane.provider.sign.VechainTransactionSignableToClause;
import network.arkane.provider.sign.VechainTransactionSigner;
import network.arkane.provider.sign.domain.TransactionSignature;
import network.arkane.provider.utils.CryptoUtils;
import network.arkane.provider.wallet.extraction.VechainPrivateKeyExtractor;
import network.arkane.provider.wallet.extraction.request.VechainPrivateKeyExtractionRequest;
import org.apache.commons.codec.binary.Hex;

import java.math.BigInteger;
import java.util.Collections;

public class TransactionService {

    public static final String CHAIN_TAG = String.valueOf((byte) 39);
    public static final String BLOCK_REF = Integer.toHexString(2721353);
    private final VechainTransactionSigner signer;

    public TransactionService() {
        signer = new VechainTransactionSigner();
    }

    public SubmissionResult executeTransaction(VechainSecretKey key) {
        TransactionSignature signedTransaction = generateTransaction(key);
        return submitTransaction(signedTransaction);
    }

    public VechainSecretKey loadWallet(String privateKey) {
        VechainPrivateKeyExtractionRequest request = new VechainPrivateKeyExtractionRequest(privateKey);
        return (VechainSecretKey) new VechainPrivateKeyExtractor().extract(request);
    }

    private TransactionSignature generateTransaction(VechainSecretKey secretKey) {
        VechainTransactionSignable signable = VechainTransactionSignable.builder()
                                                                        .gas(21000)
                                                                        .gasPriceCoef(0)
                                                                        .nonce(Hex.encodeHexString(CryptoUtils.generateTxNonce()))
                                                                        .chainTag(CHAIN_TAG)
                                                                        .blockRef(BLOCK_REF)
                                                                        .expiration(Integer.MAX_VALUE)
                                                                        .clauses(Collections.singletonList(VechainTransactionSignableToClause.builder()
                                                                                                                                             .amount(BigInteger.ONE)
                                                                                                                                             .data("0x")
                                                                                                                                             .to("0x191f00B62Ff4Ab5F543369cbF80D2F111a6d17fD")
                                                                                                                                             .build()))
                                                                        .build();
        return (TransactionSignature) signer.createSignature(signable, secretKey);
    }

    private SubmissionResult submitTransaction(TransactionSignature signedTransaction) {
        Submission submission = new Submission(signedTransaction.getSignedTransaction());
        return HttpUtil.postJson("https://thor-test.arkane.network/transactions", submission, SubmissionResult.class);
    }

    private TransactionResult getStatus(SubmissionResult submittedTransaction) {
        return HttpUtil.getJson("https://thor-test.arkane.network/transactions/" + submittedTransaction.getId(), TransactionResult.class);
    }

    public ReceiptResult getReceipt(SubmissionResult submittedTransaction) {
        return HttpUtil.getJson("https://thor-test.arkane.network/transactions/" + submittedTransaction.getId() + "/receipt", ReceiptResult.class);
    }
}
