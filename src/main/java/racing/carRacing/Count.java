package racing.carRacing;

public class Count {
    private Long count;

    Count(Long count) {
        if (isNegativeNumberOrZero(count)) {
            throw new IllegalArgumentException("0보다 큰 수를 입력해주세요.");
        }
        this.count = count;
    }

    public static Count createCount(String inputNumber) {
        return new Count(Long.parseLong(inputNumber));
    }

    private boolean isNegativeNumberOrZero(Long count) {
        return count <= 0;
    }

    @Override
    public String toString() {
        return "" + count;
    }
}
