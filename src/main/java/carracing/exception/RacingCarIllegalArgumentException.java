package carracing.exception;


public class RacingCarIllegalArgumentException extends RuntimeException {

    public static final RacingCarIllegalArgumentException INVALID_NAME_LENGTH = new RacingCarIllegalArgumentException(ErrorMessage.INVALID_NAME_LENGTH);
    public static final RacingCarIllegalArgumentException INVALID_POSITION = new RacingCarIllegalArgumentException(ErrorMessage.INVALID_POSITION);
    public static final RacingCarIllegalArgumentException INVALID_MAX_POSITION = new RacingCarIllegalArgumentException(ErrorMessage.INVALID_MAX_POSITION);

    public RacingCarIllegalArgumentException(ErrorMessage errorMessage) {
        super(errorMessage.toString());
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
