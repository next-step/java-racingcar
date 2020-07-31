package step3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RaceCondition {

    private final List<Car> cars;

    public RaceCondition(Integer participationCount) {
        this.cars = this.prepareCars(participationCount);
    }

    AttemptResult attempt() {
        return new AttemptResult(orderGo());
    }

    Integer getCarsCount() {
        return this.cars.size();
    }

    List<CarWentResult> orderGo() {
        return this.cars.stream().map(car -> car.go()).collect(Collectors.toList());
    }

    private List<Car> prepareCars(Integer participationCount) {
        return IntStream.range(0,participationCount)
                .mapToObj(index -> new Car(index))
                .collect(Collectors.toList());
    }

}
