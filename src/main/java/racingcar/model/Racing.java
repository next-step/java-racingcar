package racingcar.model;

import racingcar.view.ResultView;

import java.util.Random;

public class Racing {

    public static final Random RANDOM = new Random();

    public static void game(int count) {
        for (int i = 0; i < count; i++) {
            moveCar();
            ResultView.print();
        }
    }

    private static void moveCar() {
        for (Car car : Garage.cars) {
            car.move(RANDOM.nextInt(10));
        }
    }

}
