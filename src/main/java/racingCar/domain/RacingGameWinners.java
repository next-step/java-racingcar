package racingCar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameWinners {
    private List<RacingCar> racingCarList;

    public RacingGameWinners(List<RacingCar> racingCarList) {
        this.racingCarList = racingCarList;
        racingCarListSort();
    }

    private void racingCarListSort() {
        racingCarList = racingCarList.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<String> getWinnerNames() {
        int winnerPosition = getMaxPosition();

        return racingCarList.stream()
                            .filter(racingCar -> racingCar.getPosition() == winnerPosition)
                            .map(RacingCar::getName)
                            .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return racingCarList.stream()
                            .mapToInt(RacingCar::getPosition)
                            .max()
                            .orElse(0);
    }
}
