package step5.domain;

import step5.domain.stretagy.MovingStrategy;

import java.util.List;

public class RacingGame {

    private static final Cars cars = new Cars();

    public static void setUp(String names, MovingStrategy movingStrategy) {
        String[] split = names.split(",");
        for (String name : split) {
            cars.addCar(new Car(name, movingStrategy));
        }
    }

    public static List<String> race() {
        return cars.race();
    }

    public static List<String> getWinners() {
        return cars.getWinners();
    }

}
