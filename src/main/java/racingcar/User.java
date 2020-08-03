package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class User {
    private final Random generator;
    private final Car[] cars; // 자동차의 개수가 명확히 정해져 있어 배열을 사용하였습니다.
    private int numberOfTrials;

    public User(UserArguments args) {
        this.numberOfTrials = args.getNumberOfTrials();
        this.generator = new Random();
        this.cars = new Car[args.getNumberOfCars()];

        createCars();
    }

    private void createCars() {
        for (int i = 0; i < this.cars.length; ++ i) {
            cars[i] = Car.createCar();
        }
    }

    public boolean hasNext() {
        return (this.numberOfTrials > 0);
    }

    public void nextStep() {
        this.numberOfTrials --;
    }

    public void moveCars() {
        for (int i = 0; i < this.cars.length; ++ i) {
            int fuel = this.generator.nextInt(10);

            cars[i].move(fuel);
        }
    }

    public List<Car> getCars() {
        return Arrays.asList(this.cars);
    }

    public static User createUser(UserArguments args) {
        return new User(args);
    }
}
