package game.core.view;

public class Input {

    private String message;
    private String value;

    public Input(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}