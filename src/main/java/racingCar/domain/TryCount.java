package racingCar.domain;

public class TryCount {
    private static final int DEFAULT_TRYCOUNT = 0;
    private static final int MIN_TRY_COUNT = 1;
    private final int maxCount;
    private int presentCount;

    private TryCount(int maxCount, int presentCount) {
        this.maxCount = maxCount;
        this.presentCount = presentCount;
    }

    public static TryCount from(int maxCount) {
        validateRange(maxCount);
        return new TryCount(maxCount, DEFAULT_TRYCOUNT);
    }

    private static void validateRange(int tryCount) {
        if (!isInRagne(tryCount)) {
            throw new IllegalArgumentException(String.format("시도 횟수는 %d이상이어야 합니다.", MIN_TRY_COUNT));
        }
    }

    private static boolean isInRagne(int tryCount) {
        return tryCount >= MIN_TRY_COUNT;
    }
  
    public boolean isMaxCount() {
        return presentCount == maxCount;
    }

    public void increaseCount() {
        presentCount++;
    }
}
