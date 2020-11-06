package racingcar.exception;

public class NameTooLongException extends Exception {
    public NameTooLongException(){
        super();
    }

    public NameTooLongException(String message){
        super(message);
    }
}
