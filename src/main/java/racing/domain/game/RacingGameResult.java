package racing.domain.game;

import racing.domain.car.Car;
import racing.domain.car.RacingCars;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameResult {
    private RacingCars racingCars;
    private List<String> winnerList;

    public RacingGameResult(RacingCars racingCars, List<String> winners) {
        this.racingCars = racingCars;
        this.winnerList = getWinnerCars(getMaxPosition());
    }

    public int getMaxPosition() {
        return racingCars.getCars()
                .stream()
                .max(Comparator.comparing(Car::getPosition))
                .get()
                .getPosition();
    }

    public List<String> getWinnerCars(int maxCarPosition) {
        return racingCars.getCars()
                .stream()
                .filter(list -> list.getPosition() == maxCarPosition)
                .map(list -> list.getCarName())
                .collect(Collectors.toList());
    }

    public List<String> getWinnerList() {
        return winnerList;
    }
}
