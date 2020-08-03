package step3.collections;

import step3.Car;
import step3.dto.CarWentResult;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCars {

    private final List<Car> cars;

    public RacingCars(int participationCount) {
        this.cars = this.prepareCars(participationCount);
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

    private List<Car> prepareCars(int participationCount) {
        return IntStream.range(0,participationCount)
                .mapToObj(index -> new Car(index))
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
