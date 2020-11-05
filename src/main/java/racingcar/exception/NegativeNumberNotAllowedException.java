package racingcar.exception;

public class NegativeNumberNotAllowedException extends Exception{
    public NegativeNumberNotAllowedException(){
        super();
    }

    public NegativeNumberNotAllowedException(String message){
        super(message);
    }
}
