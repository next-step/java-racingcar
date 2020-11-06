/**
 * expression 이 유효하지 않으면 발생하는 Exception
 */
public class InvalidExpressionException extends RuntimeException {
    public InvalidExpressionException(String expression) {
        super("expression : " + expression);
    }
}
