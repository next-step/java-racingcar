package step3;

import java.util.List;
import java.util.Random;

public class Race {

    private final Car racingCars;
    private final int trial;
    private static final Random RANDOM = new Random();
    public static final int BOUND = 10;

    public Race(int count, int trial) {
        validate(count, trial);
        this.racingCars = new Car(count);
        this.trial = trial;
    }

    public void start() {
        for (int i = 0; i < this.trial; i++) {
            printRacingResult();
            System.out.println();
            sleep();
        }
    }

    public int getTrial() {
        return trial;
    }

    private void validate(int count, int trial) {
        if (isOverThan0(count, trial)) {
            throw new IllegalArgumentException("1 이상을 입력해 주세요");
        }
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void printRacingResult() {
        List<Car> cars = this.racingCars.getList();
        for (Car car : cars) {
            car.move(getRandomNumber());
            System.out.println(car.getDistance());
        }
    }

    private int getRandomNumber() {
        return RANDOM.nextInt(BOUND);
    }

    private boolean isOverThan0(int count, int trial) {
        return count < 1 || trial < 1;
    }
}
