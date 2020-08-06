package step5.collections;

import step5.Car;
import step5.collections.AttemptResult;
import step5.dto.CarWentResult;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCars {

    private final List<Car> cars;

    public RacingCars(String[] participationNames) {
        this.cars = this.prepareCars(participationNames);
    }

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public AttemptResult attempt() {
        return new AttemptResult(orderGo());
    }

    private List<CarWentResult> orderGo() {
        return this.cars.stream()
                        .map(car -> car.go())
                        .collect(Collectors.toList());
    }

    private List<Car> prepareCars(String[] participationNames) {
        return Arrays.stream(participationNames)
                    .map(name -> new Car(name))
                    .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCars that = (RacingCars) o;
        return cars.equals(that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

}
