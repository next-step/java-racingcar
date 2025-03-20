package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import calculator.StringCalculator;
import racingcar.ui.RacingCarInput;
import racingcar.ui.RacingCarInputView;
import racingcar.ui.RacingCarResultView;

public class RacingCarGame {

    public static void start() {
        RacingCarInput input = RacingCarInputView.view();

        String[] carNames = StringCalculator.split(input.getCarNameCsv());
        List<RacingCar> racingCars = RacingCar.createRacingCars(carNames);

        for (int i = 0; i < input.getTryCount(); i++) {
            RacingCarGame.moveIfMovable(racingCars);
            RacingCarResultView.view(racingCars);
        }

        List<RacingCar> winners = RacingCarGame.getWinners(racingCars);
        RacingCarResultView.winnersView(winners);
    }

    private static void moveIfMovable(List<RacingCar> racingCarList) {
        for (RacingCar car : racingCarList) {
            car.moveIfMovable();
        }
    }

    private static List<RacingCar> getWinners(List<RacingCar> racingCars) {
        if (racingCars == null || racingCars.isEmpty()) {
            return Collections.emptyList();
        }

        List<RacingCar> result = new ArrayList<>();
        racingCars = RacingCar.toSortedRacingCars(racingCars);
        RacingCar winner = racingCars.get(0);

        for (RacingCar car : racingCars) {
            if (winner.compareTo(car) < 0) {
                break;
            }
            result.add(car);
        }
        return result;
    }

}
