package racinggame.domain.exception;

public class RacingGameInputException extends IllegalArgumentException {
    private static final String CAR_NAME_EXCEPTION_MESSAGE = "자동차 이름은 공백, 중복이 존재해서는 안됩니다";
    private static final String NUMBER_OF_ATTEMPT_PARSING_EXCEPTION_MESSAGE = "시도횟수는 숫자로 입력해야합니다. : %s";
    private static final String NUMBER_OF_ATTEMPT_BOUND_EXCEPTION_MESSAGE = "시도횟수는 0보다 커야합니다";

    public RacingGameInputException(String carNameExceptionMessage) {
        super(carNameExceptionMessage);
    }

    public static RacingGameInputException ofCarNames() {
        return new RacingGameInputException(CAR_NAME_EXCEPTION_MESSAGE);
    }

    public static RacingGameInputException ofAttemptParsing(String inputNumberOfAttempt) {
        return new RacingGameInputException(String.format(NUMBER_OF_ATTEMPT_PARSING_EXCEPTION_MESSAGE, inputNumberOfAttempt));
    }

    public static RacingGameInputException ofAttemptBound() {
        return new RacingGameInputException(NUMBER_OF_ATTEMPT_BOUND_EXCEPTION_MESSAGE);
    }
}
