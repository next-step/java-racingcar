package study.step4.model.car;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;
import study.step4.model.strategy.RandomMoveStrategy;

public class Cars {

    private final List<Car> racingGameCars;

    private Cars(List<Car> cars) {
        this.racingGameCars = cars;
    }

    public static Cars of(List<Car> cars) {
        return new Cars(cars);
    }

    public static Cars of(int carNumber) {
        return Stream.generate(Car::new)
                .limit(carNumber)
                .collect(collectingAndThen(toList(), Cars::of));
    }

    public void move() {
        for (Car car : racingGameCars) {
            car.move(new RandomMoveStrategy());
        }
    }

    public List<Car> getRacingGameCars() {
        return racingGameCars;
    }

    private int getRandomNumber() {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis() * random.nextInt());
        return random.nextInt(10);
    }
}
