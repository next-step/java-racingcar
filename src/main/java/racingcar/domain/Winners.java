package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private List<String> winners;

    public Winners(RacingCars racingCars) {
        this.winners = getWinners(racingCars);
    }

    private List<String> getWinners(RacingCars racingCars) {
        int maxPosition = getHighScore(racingCars);

        return racingCars.getRacingCars().stream()
            .filter(car -> car.getPosition() == maxPosition)
            .map(RacingCar::getName)
            .collect(Collectors.toList());
    }

    private int getHighScore(RacingCars racingCars) {
        return racingCars.getRacingCars().stream()
            .mapToInt(RacingCar::getPosition)
            .max().getAsInt();
    }

    public List<String> getWinners() {
        return Collections.unmodifiableList(winners);
    }
}
