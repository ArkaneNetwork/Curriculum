package be.eurofins.vechain.vechain;

public class SubmissionResult {
    private String id;


    public SubmissionResult() {
    }

    public SubmissionResult(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "SubmissionResult{" +
               "id='" + id + '\'' +
               '}';
    }
}
