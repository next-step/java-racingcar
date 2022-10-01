package racingcar;

public class Cars {
    public static final int MIN_COUNT = 1;

    public Cars(int count) {
        validateCountOverMinimum(count);
    }

    private void validateCountOverMinimum(int count) {
        if (count < MIN_COUNT) {
            throw new IllegalArgumentException("자동차 한대 이상이 필요합니다.");
        }
    }
}
