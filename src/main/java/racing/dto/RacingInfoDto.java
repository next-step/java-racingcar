package racing.dto;

import java.util.List;
import racing.domain.Car;
import racing.domain.CarGenerator;
import racing.domain.Round;

public class RacingInfoDto {

    private final List<Car> cars;
    private final Round round;

    public RacingInfoDto(List<Car> cars, Round round) {
        this.cars = cars;
        this.round = round;
    }

    public static RacingInfoDto of(String carNames, int roundNumber) {
        final List<Car> cars = CarGenerator.createCars(carNames);
        Round round = new Round(roundNumber);
        return new RacingInfoDto(cars, round);
    }

    public List<Car> getCars() {
        return cars;
    }

    public Round getRound() {
        return round;
    }
}
