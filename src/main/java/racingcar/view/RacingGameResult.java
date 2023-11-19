package racingcar.view;

import static racingcar.constant.Constant.ENTER;

import java.util.List;
import java.util.StringJoiner;
import racingcar.domain.RacingCar;

public class RacingGameResult {

    public String create(List<RacingCar> racingCars) {
        StringJoiner stringJoiner = new StringJoiner(ENTER);
        for (RacingCar racingCar : racingCars) {
            stringJoiner.add(racingCar.movingDistance());
        }
        return stringJoiner.add(ENTER).toString();
    }
}
