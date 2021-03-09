package step2.exception;
/**
 *<pre>
 *step2.exception
 *ㄴ CheckInputException.java
 *</pre>
 *@date : 2021-03-10 오전 12:16
 *@authr : mugeon
 *@version : 1.0.0
 *@see
 **/
public class CheckInputException extends RuntimeException{

    public CheckInputException() {
        super("Please enter it correctly");
    }
}
