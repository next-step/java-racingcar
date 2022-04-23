package racingcarwinner.domain;

import racingcarwinner.Exception.NoWinnerException;

import java.util.List;
import java.util.stream.Collectors;

public class WinnerCars {

    private List<Car> winnerCars;
    private StringBuilder stringBuilder = new StringBuilder();

    public WinnerCars(ParticipatedCars participatedCars) {
        this.winnerCars = participatedCars.getMaxPositionList();
    }

    public List<Car> getWinnerCars() {
        return winnerCars;
    }

    public String getWinnerCarsName() {

        for(Car car : winnerCars) {
            stringBuilder.append(car.getCarName()).append(", ");
        }

        replaceCharacter();

        return stringBuilder.toString();
    }

    private void replaceCharacter() {
        int end = stringBuilder.toString().length();
        int start = end - 2;

        stringBuilder.replace(start, end, "");
    }

}
