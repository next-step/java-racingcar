package step4.exception;

public class MinimumTryCountException extends IllegalArgumentException {
    private final static String MINIMUM_TRY_COUNT_FIRST_WORD = "횟수를 ";
    private final static String MINIMUM_TRY_COUNT_SECOND_WORD = " 이상 입력 해야 합니다";

    public MinimumTryCountException(int minTryCount) {
        super(MINIMUM_TRY_COUNT_FIRST_WORD + minTryCount + MINIMUM_TRY_COUNT_SECOND_WORD);
    }
}
