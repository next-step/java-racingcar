package step2.exeption;

public class WrongUserInputException extends IllegalArgumentException {

    public WrongUserInputException(String s) {
        super(s);
    }
}
