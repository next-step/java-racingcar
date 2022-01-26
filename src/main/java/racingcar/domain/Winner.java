package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winner {

    private List<RacingCar> racingCarList;

    public Winner(List<RacingCar> racingCarList) {
        this.racingCarList = racingCarList;
    }

    public List<String> chooseWinner() {
        int maxPosition = racingCarList.stream()
            .mapToInt(RacingCar::getPosition)
            .max().getAsInt();

        return racingCarList.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .map(RacingCar::getName)
            .collect(Collectors.toList());
    }

}
