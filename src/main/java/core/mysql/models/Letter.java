package core.mysql.models;

public class Letter {

    private int letterId;
    private String addressee;
    private String subject;
    private String message;

    public int getLetterId() {
        return letterId;
    }

    public void setLetterId(int letterId) {
        this.letterId = letterId;
    }

    public String getAddressee() {
        return addressee;
    }

    public void setAddressee(String addressee) {
        this.addressee = addressee;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Letter ID = " + letterId +
                "\n\taddressee = " + addressee +
                "\n\tsubject = " + subject +
                "\n\tmessage = " + message;
    }
}
