package study.racingcar.model;

public class TryRound {
    private static final String EXCEPTION_MESSAGE_MIN_TRY_ROUND = "시도 횟수가 1보다 작은 수 입니다.";
    private static final int MIN_INPUT_NUMBER = 1;

    private final int tryRound;

    public TryRound(int tryRound) {
        if (MIN_INPUT_NUMBER > tryRound) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_MIN_TRY_ROUND);
        }
        this.tryRound = tryRound;
    }

    /**
     * 시도 횟수 조회
     * @return 시도 횟수
     */
    public int getTryRound() {
        return tryRound;
    };
}
