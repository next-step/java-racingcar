package racingcar;


import racingcar.service.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static racingcar.service.Car.race;
import static racingcar.service.RacingWinner.getWinnerNames;
import static racingcar.view.InputView.input;
import static racingcar.view.ResultView.view;
import static racingcar.view.ResultView.viewWinners;

public class RacingCarApplication {
    public static final Random random = new Random();

    public static void main(String[] args) {
        final var input = input();
        List<String> carNames = Arrays.asList((String[]) input.get(0));
        int labs = (int) input.get(1);

        List<Car> racingCars = new ArrayList<>();
        for (int car = 0; car < carNames.size(); car++) {
            racingCars.add(new Car(carNames.get(car), race(labs)));
        }

        view(racingCars);
        viewWinners(getWinnerNames(racingCars));
    }

}
