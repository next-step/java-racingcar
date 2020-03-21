package racingcar.domain;

import racingcar.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame implements RacingGameRule {

    private int time;
    private int[] carPosition;

    public RacingGame(int time, int totalCarCount) {
        this.time = time;
        this.carPosition = new int[totalCarCount];
    }

    public CarPositions game() {
        List<int[]> carPositions = new ArrayList<>();
        for (int i = 0; i < time; i++) {
            move();
            carPositions.add(carPosition.clone());
        }
        return new CarPositions(carPositions);
    }


    private void move() {
        for (int carNumber = 0; carNumber < carPosition.length; carNumber++) {
            forward(carNumber);
        }
    }

    private void forward(int carNumber) {
        int condition = new Random().nextInt(Constant.RANDOM_LIMIT);
        if (isForward(condition)) {
            carPosition[carNumber]++;
        }
    }

    @Override
    public boolean isForward(int condition) {
        return condition >= Constant.APPROVE_CONDITION;
    }
}
