package racingcar;


import racingcar.service.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static racingcar.service.Car.race;
import static racingcar.view.InputView.input;
import static racingcar.view.ResultView.view;

public class RacingCarApplication {
    public static final Random random = new Random();

    public static void main(String[] args) {
        final var input = input();
        int cars = input.get(0);
        int labs = input.get(1);

        List<Car> racingCars = new ArrayList<>();
        for(int car=0; car < cars; car++){
            racingCars.add(new Car(race(labs)));
        }

        view(racingCars);
    }
}
