package racingGame;

import racingGame.model.RacingCar;
import racingGame.util.Lottery;

import java.util.ArrayList;

public class RacingGame {
    private static int LESS_MOVE_RANGE = 3;
    private static int GREATER_MOVE_RANGE = 11;
    private ArrayList<RacingCar> racingCars = new ArrayList<>();
    private int cars;
    private int times;
    private int remainTimes;

    RacingGame(int cars, int times) {
        this.cars = cars;
        this.times = times;
        this.remainTimes = times;

        this.initRacingCars();
    }

    public void move() {
        if (this.remainTimes > 0) {
            this.moveCars();
            this.remainTimes -= 1;
        }
    }

    public void moveCars() {
        for (RacingCar racingCar : this.racingCars) {
            if (this.isForward(Lottery.getLotteryNumber())) {
                racingCar.setForward();
            }
        }
    }

    public boolean isForward(int number) {
        return number > LESS_MOVE_RANGE && number < GREATER_MOVE_RANGE;
    }

    public boolean hasRemainTime() {
        return this.remainTimes > 0;
    }

    public ArrayList<Integer> getCarPositions() {
        ArrayList<Integer> carPositions = new ArrayList<>();
        for (RacingCar racingCar : this.racingCars) {
            carPositions.add(racingCar.getPosition());
        }

        return carPositions;
    }

    private void initRacingCars() {
        if (this.cars < 1 || this.times < 0) {
            return;
        }

        // 경주용 자동차 초기화
        for (int i = 0, len = this.cars; i < len; i++) {
            this.racingCars.add(new RacingCar());
        }
    }
}
