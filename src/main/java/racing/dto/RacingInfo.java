package racing.dto;

import java.util.List;
import racing.domain.Car;
import racing.domain.CarGenerator;
import racing.domain.MoveRule;

public class RacingInfo {

    private final List<Car> cars;
    private final int totalRoundNumber;

    public RacingInfo(List<Car> cars, int totalRoundNumber) {
        this.cars = cars;
        this.totalRoundNumber = totalRoundNumber;
    }

    public static RacingInfo of(String carNames, int totalRoundNumber, MoveRule moveRule) {
        final List<Car> cars = CarGenerator.createCars(carNames, moveRule);
        return new RacingInfo(cars, totalRoundNumber);
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getTotalRoundNumber() {
        return totalRoundNumber;
    }
}
