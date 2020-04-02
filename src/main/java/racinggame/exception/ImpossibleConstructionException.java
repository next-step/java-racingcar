package racinggame.exception;

public class ImpossibleConstructionException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "객체 생성이 금지되어 있습니다. : %s";

    public ImpossibleConstructionException(final String message) {
        super(String.format(DEFAULT_MESSAGE, message));
    }
}
