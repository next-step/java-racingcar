package step5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacingGame {

    private List<Car> cars;

    public CarRacingGame(String[] carNames) {
        cars = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i], new RandomMoveStrategy()));
        }
    }

    public List<CarDTO> getCars() {
        return cars.stream()
            .map(CarDTO::new)
            .collect(Collectors.toList());
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<CarDTO> getWinners() {
        return Referee.getWinners(cars)
            .stream().map(CarDTO::new)
            .collect(Collectors.toList());
    }
}
