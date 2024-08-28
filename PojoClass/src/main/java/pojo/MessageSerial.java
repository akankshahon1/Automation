package pojo;

public class MessageSerial {
    private String message;
    private String greet;
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getGreet() {
        return greet;
    }
    public void setGreet(String greet) {
        this.greet = greet;
    }
    public static void main(String args[]){
        MessageSerial m = new MessageSerial();
        m.setMessage("Hello World");
        m.setGreet("Hello Wesco");
    }
}
