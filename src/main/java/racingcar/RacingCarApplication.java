package racingcar;


import racingcar.service.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static racingcar.service.Car.race;
import static racingcar.service.RacingWinner.getWinnerNames;
import static racingcar.view.InputView.askQuestionCarNames;
import static racingcar.view.InputView.askQuestionLabs;
import static racingcar.view.ResultView.view;
import static racingcar.view.ResultView.viewWinners;

public class RacingCarApplication {
    public static final Random random = new Random();

    public static void main(String[] args) {
        List<String> carNames = askQuestionCarNames();
        int labs = askQuestionLabs();

        List<Car> racingCars = new ArrayList<>();
        for (int car = 0; car < carNames.size(); car++) {
            racingCars.add(new Car(carNames.get(car), race(labs)));
        }

        view(racingCars);
        viewWinners(getWinnerNames(racingCars));
    }

}
