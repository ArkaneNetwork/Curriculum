package be.eurofins.vechain.vechain;

public class ReceiptResult {
    private String gasUsed;
    private String gasPayer;
    private String paid;
    private String reward;
    private String reverted;

    public ReceiptResult() {
    }

    public String getGasUsed() {
        return gasUsed;
    }

    public void setGasUsed(String gasUsed) {
        this.gasUsed = gasUsed;
    }

    public String getGasPayer() {
        return gasPayer;
    }

    public void setGasPayer(String gasPayer) {
        this.gasPayer = gasPayer;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public String getReverted() {
        return reverted;
    }

    public void setReverted(String reverted) {
        this.reverted = reverted;
    }

    @Override
    public String toString() {
        return "ReceiptResult{" +
               "gasUsed='" + gasUsed + '\'' +
               ", gasPayer='" + gasPayer + '\'' +
               ", paid='" + paid + '\'' +
               ", reward='" + reward + '\'' +
               ", reverted='" + reverted + '\'' +
               '}';
    }
}
