package racing.board;

import racing.model.RacingCar;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GameResult {

    private List<RacingCar> cars;

    public GameResult(List<RacingCar> cars) {
        this.cars = cars;
    }

    public List<RacingCar> getWinners() {
        if (cars.size() == 0) {
            return Collections.emptyList();
        }

        RacingCar mostFarPositionedCar = Collections.max(cars);
        return cars.stream()
                .filter(car -> car.compareTo(mostFarPositionedCar) == 0)
                .collect(Collectors.toList());
    }
}
