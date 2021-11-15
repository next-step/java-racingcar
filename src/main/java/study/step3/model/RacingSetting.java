package study.step3.model;

public class RacingSetting {
    private static final String EXCEPTION_MESSAGE_MIN_CAR_COUNT = "주행 차량 수가 1보다 작은 수 입니다.";
    private static final String EXCEPTION_MESSAGE_MIN_TRY_ROUND = "시도 횟수가 1보다 작은 수 입니다.";
    private static final int MIN_INPUT_NUMBER = 1;

    private int carCount;
    private int tryRound;

    /**
     * 생성자
     */
    public RacingSetting(int carCount, int tryRound) {
        validateCarCount(carCount);
        validateTryRound(tryRound);

        this.carCount = carCount;
        this.tryRound = tryRound;
    }

    /**
     * 주행 차량 수 Validation 체크
     * @param carCount 주행 차량 수
     */
    private static void validateCarCount(int carCount) {
        if (MIN_INPUT_NUMBER > carCount) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_MIN_CAR_COUNT);
        }
    }

    /**
     * 시도 횟수 Validation 체크
     * @param tryRound 시도 횟수
     */
    private static void validateTryRound(int tryRound) {
        if (MIN_INPUT_NUMBER > tryRound) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_MIN_TRY_ROUND);
        }
    }

    /**
     * 주행 차량 수 조회
     * @return 주행 차량 수
     */
    public int getCarCount() {
        return carCount;
    }

    /**
     * 시도 횟수 조회
     * @return 시도 횟수
     */
    public int getTryRound() {
        return tryRound;
    };

}
