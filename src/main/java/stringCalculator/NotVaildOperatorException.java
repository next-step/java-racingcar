package stringCalculator;

public class NotVaildOperatorException extends IllegalArgumentException{

    NotVaildOperatorException() {
        super();
    }

    NotVaildOperatorException(String message) {
        super(message);
    }
}
