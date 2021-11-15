package step5;

import java.util.List;
import java.util.stream.Collectors;

public class CarRacingGame {

    private final Cars cars;

    public CarRacingGame(String[] carNames) {
        cars = new Cars(carNames);
    }

    public List<CarDTO> getCars() {
        return cars.getCars()
            .stream()
            .map(CarDTO::new)
            .collect(Collectors.toList());
    }

    public void moveCars() {
        cars.move();
    }

    public List<CarDTO> getWinners() {
        return cars.getWinners()
            .getCars()
            .stream()
            .map(CarDTO::new)
            .collect(Collectors.toList());
    }
}
