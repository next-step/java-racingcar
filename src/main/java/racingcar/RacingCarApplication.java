package racingcar;


import racingcar.service.RacingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static racingcar.service.RacingCar.race;
import static racingcar.view.InputView.input;
import static racingcar.view.ResultView.view;

public class RacingCarApplication {
    public static final Random random = new Random();

    public static void main(String[] args) {
        final var input = input();
        int cars = input.get(0);
        int raceTry = input.get(1);

        List<RacingCar> racingCars = new ArrayList<>();
        for(int car=0; car < cars; car++){
            racingCars.add(new RacingCar(race(raceTry)));
        }

        view(racingCars);
    }
}
