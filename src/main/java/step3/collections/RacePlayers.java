package step3.collections;

import step3.Car;
import step3.dto.CarWentResult;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacePlayers {

    private final List<Car> cars;

    public RacePlayers(Integer participationCount) {
        this.cars = this.prepareCars(participationCount);
    }

    public RacePlayers(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacePlayers that = (RacePlayers) o;
        return cars.equals(that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

    public AttemptResult attempt() {
        return new AttemptResult(orderGo());
    }

    private List<CarWentResult> orderGo() {
        return this.cars.stream()
                        .map(car -> car.go())
                        .collect(Collectors.toList());
    }

    private List<Car> prepareCars(Integer participationCount) {
        return IntStream.range(0,participationCount)
                .mapToObj(index -> new Car(index))
                .peek(car -> System.out.println(car.getCarNumber()))
                .collect(Collectors.toList());
    }

}
