package race;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Car {
    private int step;

    private final String name;

    private Car(int step, String name) {
        this.step = step;
        this.name = name;
    }

    public int getStep() {
        return this.step;
    }

    public String getName() {
        return this.name;
    }

    public void moveBy(CarMoveRule carMoveRule) {
        if (carMoveRule.check()) {
            this.step++;
        }
    }

    public static Car create(int startStep, String name) {
        return new Car(startStep, name);
    }

    public static List<Car> create(int startStep, List<String> names) {
        return names.stream().map((name) -> Car.create(startStep, name)).collect(Collectors.toList());
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
