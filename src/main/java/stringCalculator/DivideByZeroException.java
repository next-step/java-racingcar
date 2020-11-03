package stringCalculator;

public class DivideByZeroException extends IllegalArgumentException {
    DivideByZeroException(){
        super();
    }

    DivideByZeroException(String message){
        super(message);
    }
}
