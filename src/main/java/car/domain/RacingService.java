package car.domain;

import car.domain.model.Car;
import car.domain.model.Cars;
import car.domain.model.Count;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingService {

    private Cars cars;
    private Count count;

    public RacingService(final String inputCarNames, final int inputCount) {
        System.out.println("실행 결과");
        this.cars = new Cars(inputCarNames);
        this.count = new Count(inputCount);
    }

    public Cars runRaceOnce() {
        this.cars.raceOnce();
        return this.getRaceResult();
    }

    public Cars getRaceResult() {
        return this.cars;
    }

    public List<Car> selectWinner() {
        int maxPos = this.cars.getCars()
            .stream()
            .map(Car::getPosition)
            .max(Comparator.comparing(x -> x)).get();
        return this.cars.getCars()
            .stream()
            .filter(s -> (s.getPosition() == maxPos))
            .collect(Collectors.toList());
    }

}
