package be.eurofins.vechain.vechain;

public class Submission {
    private String raw;


    public Submission() {
    }

    public Submission(String raw) {
        this.raw = raw;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }
}
