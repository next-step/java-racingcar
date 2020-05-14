package racingcar;

import util.CommonUtil;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private static final int GO_CONDITION_COUNT = 4;
    private static final int RANDOM_BOUNDARY = 10;
    private static final int INPUT_ERROR_MIN_NUMBER = 0;
    private static final int START_ROUND = 0;
    private static final int GO = 1;
    private static final int STOP = 0;

    private int time;
    private int carCount;
    private List<Racingcar> carPositions = new ArrayList<>();

    public RacingGame(int carCount, int time) {
        validate();
        this.time = time;
        this.carCount = carCount;
    }

    public ResultView start() {
        createCar();

        ResultView resultView = new ResultView();

        for (int i = START_ROUND; i < time; i++) {
            move(i);
            resultView.saveRoundResult(i, this.carPositions);
        }

        return resultView;
    }

    private void validate() {
        if (this.time < INPUT_ERROR_MIN_NUMBER) {
            throw new IllegalArgumentException("time is small than zero");
        }

        if (this.carCount < INPUT_ERROR_MIN_NUMBER) {
            throw new IllegalArgumentException("carCount is small than zero");
        }
    }

    private void move(int round) {
        for (Racingcar racingcar : this.carPositions) {
            int getPosition = racingcar.getCarMovePosition();
            racingcar.setCarMovePosition(round, getPosition + roundMoveResult());
        }
    }

    private int roundMoveResult() {
        return CommonUtil.randomNumber(RANDOM_BOUNDARY) > GO_CONDITION_COUNT ? GO : STOP;
    }

    private void createCar() {
        for (int i = 0; i < carCount; i++) {
            Racingcar racingcar = new Racingcar(i);
            carPositions.add(racingcar);
        }
    }

}