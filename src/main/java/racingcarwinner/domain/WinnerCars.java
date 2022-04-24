package racingcarwinner.domain;

import java.util.List;
import java.util.stream.Collectors;

public class WinnerCars {

    private final List<Car> winnerCars;
    private final StringBuilder stringBuilder = new StringBuilder();

    public WinnerCars(ParticipatedCars participatedCars) {
        this.winnerCars = participatedCars.getMaxPositionList();
    }

    public List<Car> getWinnerCars() {
        return winnerCars;
    }

    public String getWinnerCarsName() {
        return winnerCars.stream().map(Car::getCarName).collect(Collectors.joining(", "));
    }

}
