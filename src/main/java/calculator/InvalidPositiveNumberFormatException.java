package calculator;

public class InvalidPositiveNumberFormatException extends RuntimeException {

    public InvalidPositiveNumberFormatException() {
        this("유효하지 않은 양수 형식입니다.");
    }

    public InvalidPositiveNumberFormatException(String msg) {
        super(msg);
    }
}
