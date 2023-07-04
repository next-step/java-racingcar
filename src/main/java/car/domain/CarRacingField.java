package car.domain;

import car.dto.CarStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import utils.random.RandomGenerator;
import car.domain.winnerstrategy.WinnerStrategy;

public class CarRacingField {

    private List<Car> cars = new ArrayList<>();
    private WinnerStrategy winnerStrategy;

    public CarRacingField(List<String> carNames, WinnerStrategy winnerStrategy) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        this.winnerStrategy = winnerStrategy;
    }

    public List<CarStatus> getCarStatuses() {
        return cars.stream()
            .map(CarStatus::from)
            .collect(Collectors.toList());
    }

    public void moveOrStopCars() {
        for (Car car : cars) {
            car.moveOrStopByValue(RandomGenerator.extractRandomSingleDigit());
        }
    }

    public List<Car> getWinners() {
        return winnerStrategy.getWinners(cars);
    }
}
