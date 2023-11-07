package step3.model;

import step3.view.RaceResultView;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Race {

    private static final Random random = new Random();
    private static final int MAX_RANDOM_VALUE = 10;
    private final List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public void playing(int times) {
        IntStream.range(0, times).forEach(t -> {
            cars.forEach(Car::go);
            new RaceResultView(cars).show();
        });
    }

    public static int getRandomValue() {
        return random.nextInt(MAX_RANDOM_VALUE);
    }
}

