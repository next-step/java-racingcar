package step3;

import step3.dto.CarWentResult;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacePlayers {

    private final List<Car> cars;

    public RacePlayers(Integer participationCount) {
        this.cars = this.prepareCars(participationCount);
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
                .collect(Collectors.toList());
    }

}
