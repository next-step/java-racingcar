package racingGame;

import java.util.List;
import java.util.Objects;

public class Car {
    private List<String> carMarks;
    public Car(List<String> carMarks) {
        this.carMarks = carMarks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carMarks, car.carMarks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carMarks);
    }
}
