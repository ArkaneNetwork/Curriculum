package be.eurofins.vechain.vechain;

public class TransactionResult {
    private String id;
    private String chainTag;
    private String blockRef;
    private String expiration;
    private String gasPriceCoef;
    private String gas;
    private String origin;
    private String nonce;

    public TransactionResult() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChainTag() {
        return chainTag;
    }

    public void setChainTag(String chainTag) {
        this.chainTag = chainTag;
    }

    public String getBlockRef() {
        return blockRef;
    }

    public void setBlockRef(String blockRef) {
        this.blockRef = blockRef;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getGasPriceCoef() {
        return gasPriceCoef;
    }

    public void setGasPriceCoef(String gasPriceCoef) {
        this.gasPriceCoef = gasPriceCoef;
    }

    public String getGas() {
        return gas;
    }

    public void setGas(String gas) {
        this.gas = gas;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    @Override
    public String toString() {
        return "TransactionResult{" +
               "id='" + id + '\'' +
               ", chainTag='" + chainTag + '\'' +
               ", blockRef='" + blockRef + '\'' +
               ", expiration='" + expiration + '\'' +
               ", gasPriceCoef='" + gasPriceCoef + '\'' +
               ", gas='" + gas + '\'' +
               ", origin='" + origin + '\'' +
               ", nonce='" + nonce + '\'' +
               '}';
    }
}
