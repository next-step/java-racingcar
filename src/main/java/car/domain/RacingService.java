package car.domain;

import car.domain.model.Car;
import car.domain.model.Cars;
import car.domain.model.Count;
import java.util.List;
import java.util.stream.Collectors;

public class RacingService {

    private final Cars cars;
    private final Count count;

    public RacingService(final String inputCarNames, final int inputCount) {
        System.out.println("실행 결과");
        this.cars = new Cars(inputCarNames);
        this.count = new Count(inputCount);
    }

    public boolean isRacing() {
        return count.isRacingRemain();
    }

    public void runRaceOnce() {
        count.decreaseTryCount();
        cars.raceOnce();
    }

    public Cars getEachRaceResult() {
        return cars;
    }

    public List<Car> selectWinner() {
        int maxPosition = this.cars.getCars()
            .stream()
            .mapToInt(Car::getPosition)
            .max().getAsInt();
        return this.cars.getCars()
            .stream()
            .filter(car -> (car.getPosition() == maxPosition))
            .collect(Collectors.toList());
    }

}
