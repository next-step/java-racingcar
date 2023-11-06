package racingcar.domain;

import java.util.List;
import java.util.StringJoiner;

public class RacingGameResult {
    private static final String ENTER = "\n";

    public String create(List<RacingCar> racingCars) {
        StringJoiner stringJoiner = new StringJoiner(ENTER);
        for (RacingCar racingCar : racingCars) {
            stringJoiner.add(racingCar.movingDistance());
        }
        return stringJoiner.add(ENTER).toString();
    }
}
