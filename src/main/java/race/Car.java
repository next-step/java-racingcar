package race;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Car {
    private int step;

    private Car(int step) {
        this.step = step;
    }

    public int getStep() {
        return this.step;
    }

    public void moveBy(CarMoveRule carMoveRule) {
        if (carMoveRule.check()) {
            this.step++;
        }
    }

    public static Car create(int startStep) {
        return new Car(startStep);
    }

    public static List<Car> create(int startStep, int count) {
        return Stream.generate(() -> Car.create(startStep)).limit(count).collect(Collectors.toList());
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
