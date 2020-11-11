package step3.domain;

public class InvalidCarNameException extends RuntimeException {
    public InvalidCarNameException(String name) {
        super("name is '" + name + "'");
    }
}
