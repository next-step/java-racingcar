package step3_CarRacing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Race {
    private final Random random;
    private final List<Car> cars;

    public Race(int numberOfCars) {
        if (numberOfCars < 0) throw new IllegalArgumentException("0이상이어야 함");
        random = new Random();

        cars = new ArrayList<>();
        IntStream.range(0, numberOfCars).forEach(car -> cars.add(new Car()));
    }

    public List<Car> getCars() {
        return cars;
    }

    public void runRound() {
        cars.forEach(car -> car.move(random.nextInt(10)));
    }
}
