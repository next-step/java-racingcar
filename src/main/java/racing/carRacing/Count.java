package racing.carRacing;

import java.util.List;

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

    public List<Car> initCars(List<Car> cars) {
        for (int i = 0; i < count; i++) {
            cars.add(new Car(""));
        }
        return cars;
    }

    public boolean isOverZero() {
        return count > 0;
    }

    public void countDown() {
        count -= 1L;
    }

    @Override
    public String toString() {
        return "" + count;
    }
}
