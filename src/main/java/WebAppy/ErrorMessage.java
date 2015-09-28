package WebAppy;

public class ErrorMessage {
    
    private String message;
    private String type;
    
    ErrorMessage(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getType() {
        return type;
    }
    
}
