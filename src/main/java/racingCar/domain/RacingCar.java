package racingCar.domain;

import java.util.List;
import java.util.Random;

public class RacingCar {
    private static final int RANDOM_BOUND = 10;
    private int trial;
    public int maxPosition = 0;
    private Random random = new Random();

    public RacingCar(int trial) { this.trial = trial; }

    public RacingCar(int trial, int maxPosition) {
        this(trial);
        this.maxPosition = maxPosition;
    }

    public void run(List<Car> cars) {
        if (this.trial-- < 0) {
            trial = 0;
        }
        racingCar(cars);
    }

    public boolean isEnd() {
        if (this.trial > 0) {
            return false;
        }
        return true;
    }

    private int getRandomNumber() {
        return random.nextInt(RANDOM_BOUND);
    }

    private void racingCar(List<Car> cars) {
        for (Car car : cars) {
            racingStep(car,getRandomNumber());
        }
    }

    private void racingStep(Car car, int number) {
        car.step(number);
        setMaxPosition(car.getPosition());
    }

    protected void setMaxPosition(int position) {
        if(maxPosition < position)
            maxPosition = position;
    }

    public void setWinner(List<Car> cars) {
        for (Car car : cars) {
            car.winnerCheck(maxPosition);
        }
    }

}




