package racingcar;


import racingcar.dto.Car;
import racingcar.dto.Cars;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static racingcar.service.Racing.race;
import static racingcar.service.RacingWinners.getWinnerNames;
import static racingcar.view.InputView.askQuestionCarNames;
import static racingcar.view.InputView.askQuestionLabs;
import static racingcar.view.ResultView.view;
import static racingcar.view.ResultView.viewWinners;

public class RacingCarApplication {
    public static final Random random = new Random();

    public static void main(String[] args) {
        Cars cars = new Cars(makeRacingCars(askQuestionCarNames(), askQuestionLabs()));

        view(cars);
        viewWinners(getWinnerNames(cars));
    }

    private static List<Car> makeRacingCars(List<String> carNames, int labs) {
        List<Car> racingCars = new ArrayList<>();

        for (int car = 0; car < carNames.size(); car++) {
            racingCars.add(new Car(carNames.get(car), race(labs)));
        }

        return racingCars;
    }

}
