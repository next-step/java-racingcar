package game;

/**
 * @author : yusik
 * @date : 2019/10/26
 */
public class UserInput<T> {

    private String message;
    private T value;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
