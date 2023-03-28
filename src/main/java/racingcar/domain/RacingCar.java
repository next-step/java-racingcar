package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCar {
    private static final int RANDOM_BOUND = 10;
    private final Cars cars;
    private int trial;
    public int maxPosition = 0;
    private final Random random = new Random();

    public RacingCar(Cars cars, int trial) {
        this.cars = cars;
        this.trial = trial;
    }

    public void run() {
        if (this.trial-- < 0) {
            trial = 0;
        }
        for (Car car : this.cars.getCars()) {
            car.step(getRandomNumber());
        }
    }

    public boolean isEnd() {
        return (this.trial <= 0);
    }

    private int getRandomNumber() {
        return random.nextInt(RANDOM_BOUND);
    }

    public Cars getCars() {
        return cars;
    }

    public Cars getWinner() {
        List<Car> winners = new ArrayList<>();
        for (Car car : this.cars.getCars()) {
            setWinner(car, winners);
        }
        return new Cars(winners);
    }

    private void setWinner(Car car, List<Car> winners) {
        if (car.getPosition() > maxPosition) {
            maxPosition = car.getPosition();
            winners.clear();
        }
        if (car.getPosition() >= maxPosition) {
            winners.add(car);
        }
    }

}
