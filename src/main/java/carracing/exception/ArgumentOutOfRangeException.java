package carracing.exception;

public class ArgumentOutOfRangeException extends IllegalArgumentException {

    private static final String MAXIMUM_RANGE_EXCEPTION = "최대 길이(%d)를 초과하였습니다.";

    public ArgumentOutOfRangeException(Integer maximum) {
        super(String.format(MAXIMUM_RANGE_EXCEPTION, maximum));
    }

}
