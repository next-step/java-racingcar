package calculator.exception;


/**
 * 해당 OperatorNotFoundException 은 OperatorEnum에서
 * keyword에 맞는 Operator를 찾지 못했을때 발생한다.
 *
 * @author isntyet
 */
public class OperatorNotFoundException extends RuntimeException {

    public OperatorNotFoundException(String message) {
        super(message);
    }

    public OperatorNotFoundException(Throwable cause) {
        super(cause);
    }

    public OperatorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
