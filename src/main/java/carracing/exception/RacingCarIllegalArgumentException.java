package carracing.exception;


public class RacingCarIllegalArgumentException extends RuntimeException {

    public static final RacingCarIllegalArgumentException INVALID_NAME_LENGTH = new RacingCarIllegalArgumentException(ErrorMessage.INVALID_NAME_LENGTH);

    public RacingCarIllegalArgumentException(ErrorMessage errorMessage) {
        super(errorMessage.toString());
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
