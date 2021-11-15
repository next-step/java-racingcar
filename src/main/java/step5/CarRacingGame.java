package step5;

import java.util.List;
import java.util.stream.Collectors;

public class CarRacingGame {

    private final Cars cars;
    private int roundCount;

    public CarRacingGame(int roundCount, String[] carNames) {
        this.roundCount = roundCount;
        this.cars = new Cars(carNames);
    }

    public static List<CarDTO> getCars(Cars cars) {
        return cars.getCars()
            .stream()
            .map(CarDTO::new)
            .collect(Collectors.toList());
    }

    public List<CarDTO> getCars() {
        return getCars(cars);
    }

    public List<CarDTO> getWinners() {
        return getCars(cars.getWinners());
    }

    public boolean hasMoreRounds() {
        return roundCount > 0;
    }

    public void moveCars() {
        roundCount--;
        cars.move();
    }

}
