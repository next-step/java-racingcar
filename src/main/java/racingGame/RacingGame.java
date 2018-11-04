package racingGame;

import java.util.ArrayList;
import java.util.Random;

public class RacingGame {
    Random random = new Random();
    RacingGameLogger logger;

    public ArrayList<Integer> move(int cars, int times) {
        if (cars < 1 || times < 0) {
            return new ArrayList<>();
        }

        ArrayList<Integer> carPositions = new ArrayList<>(cars);

        // 자동차 위치값 초기화
        for (int i = 0, len = cars; i < len; i++) {
            carPositions.add(0);
        }

        for (int time = 0; time < times; time++) {
            this.moveCars(carPositions);

            if (this.logger != null) {
                this.logger.log(carPositions);
            }
        }

        return carPositions;
    }

    public boolean isForward(int number) {
        return number > 3 && number < 11;
    }

    public Integer getLotteryNumber() {
        return random.nextInt(10);
    }

    public void setForward(ArrayList<Integer> carPositions, int carPosition) {
        if (carPositions == null || carPositions.isEmpty() || carPositions.size() <= carPosition) {
            return;
        }

        carPositions.set(carPosition, carPositions.get(carPosition) + 1);
    }

    public void moveCars(ArrayList<Integer> carPositions) {
        for (int car = 0, cars = carPositions.size(); car < cars; car++) {
            if (this.isForward(this.getLotteryNumber())) {
                this.setForward(carPositions, car);
            }
        }
    }

    public void setLogger(RacingGameLogger logger) {
        this.logger = logger;
    }
}
