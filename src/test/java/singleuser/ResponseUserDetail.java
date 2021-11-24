package singleuser;

public class ResponseUserDetail {
    private String code;
    private String type;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "code: "+code+"\n"+
                "type: "+type+"\n"+
                "message: "+message+"\n";
    }
}
