package stringCalculator;

public class NullAndBlankException extends IllegalArgumentException{
    NullAndBlankException(){
        super();
    }

    NullAndBlankException(String message){
        super(message);
    }
}
