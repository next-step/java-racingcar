package step3.exception;

public class NoProceedPolicyException extends RuntimeException {

    public NoProceedPolicyException(String message) {
        super(message);
    }

}
