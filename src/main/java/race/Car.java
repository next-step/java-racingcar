package race;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Car {
    private static final int MAX_LENGTH_OF_NAME = 5;

    private int step;

    private final String name;

    private Car(int step, String name) {
        this.step = step;
        this.name = name;
    }

    public void moveBy(CarMoveRule carMoveRule, CarMoveRuleValue carMoveRuleValue) {
        if (carMoveRule.check(carMoveRuleValue)) {
            this.step++;
        }
    }

    public CarRaceGameHistory recordHistory(int round) {
        return CarRaceGameHistory.record(round, step, name);
    }


    public static Car create(int startStep, String name) {
        if (name.length() > MAX_LENGTH_OF_NAME) {
            throw new IllegalArgumentException("이름은 최대 5자 이하로 입력 가능합니다.");
        }

        return new Car(startStep, name);
    }

    public static List<Car> create(int startStep, List<String> names) {
        return names.stream()
                    .map((name) -> Car.create(startStep, name))
                    .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return step == car.step;
    }

    @Override
    public int hashCode() {
        return Objects.hash(step);
    }
}
