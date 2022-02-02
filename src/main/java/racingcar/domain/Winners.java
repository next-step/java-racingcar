package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private List<String> racingWinnerLists;

    public Winners(List<RacingCar> racingCarLists) {
        this.racingWinnerLists = getWinners(racingCarLists);
    }

    private List<String> getWinners(List<RacingCar> racingCarLists) {
        int maxPosition = getHighScore(racingCarLists);

        return racingCarLists.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .map(RacingCar::getName)
            .collect(Collectors.toList());
    }

    private int getHighScore(List<RacingCar> racingCarLists) {
        return racingCarLists.stream()
            .mapToInt(RacingCar::getPosition)
            .max().getAsInt();
    }

    public List<String> getRacingWinnerLists() {
        return Collections.unmodifiableList(racingWinnerLists);
    }
}
