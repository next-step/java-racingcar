package racingcar.car;

public class CountOfCars {
    private static int MINIMUM_COUNT = 1;

    private int count;

    private CountOfCars(int count) {
        validate(count);
        this.count = count;
    }

    private void validate(int count) {
        if (count < MINIMUM_COUNT) {
            throw new IllegalArgumentException("최소 1대 이상의 자동차를 생성해야합니다.");
        }
    }

    public static CountOfCars newInstance(int count) {
        return new CountOfCars(count);
    }

    public int getCount() {
        return count;
    }
}
