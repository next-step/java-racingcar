package racingcar.car;

public class CountOfCars {
    private int count;

    public CountOfCars(int count) {
        validate(count);
        this.count = count;
    }

    private void validate(int count) {
        if (count < 1) {
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
