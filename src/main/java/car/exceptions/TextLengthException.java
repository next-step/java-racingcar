package car.exceptions;

public class TextLengthException extends RuntimeException {

    public TextLengthException(int textLenght, String exceptionMessage) {
        super(textLenght + exceptionMessage);
    }
}
