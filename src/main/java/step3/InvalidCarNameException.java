package step3;

public class InvalidCarNameException extends RuntimeException {
    public InvalidCarNameException(String name) {
        super("name is '" + name + "'");
    }
}
