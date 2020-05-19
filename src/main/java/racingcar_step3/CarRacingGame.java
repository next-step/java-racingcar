package racingcar_step3;

import java.util.List;
import java.util.Random;

public class CarRacingGame {

    private Random rand = new Random();
    private List<Integer> racingPositions;
    private Car car;

    CarRacingGame(Car car) {
        this.car = car;
        racingPositions = car.getCarPositions();
    }

    private int getRandom() {
        return rand.nextInt(CarRacingEnum.RANDOM_RANGE.getValue());
    }

    public void runRacing() {
        for (int i=0; i < car.getRacingCount(); i++) {
            move();
        }
    }

    private void move() {
        for (int i=0; i < car.getRacingCarCount(); i++) {
            int carPosition = car.getCarPositions().get(i);
            carPosition += car.setForward(getRandom());
            racingPositions.set(i, carPosition);
        }
    }

    public List<Integer> getRacingPositions() {
        return this.racingPositions;
    }
}
