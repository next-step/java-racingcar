package racingcar;

import util.CommonUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGame {

    private static final int GO_CONDITION_COUNT = 4;
    private static final int RANDOM_BOUNDARY = 10;
    private static final int INPUT_ERROR_MIN_NUMBER = 0;
    private static final int START_ROUND = 0;
    private static final int GO = 1;
    private static final int STOP = 0;
    private static final String CAR_NAME_SPLITER = ",";

    private int time;
    private List<String> carNames = new ArrayList<>();
    private List<Racingcar> carPositions = new ArrayList<>();

    public RacingGame(String carNames, int time) {
        validateTime(time);
        String[] splitCarNames = carNames.split(CAR_NAME_SPLITER);
        this.time = time;
        this.carNames = Arrays.asList(splitCarNames);
    }

    public ResultView start() {
        prepareToRace();

        ResultView resultView = new ResultView();

        for (int i = START_ROUND; i < time; i++) {
            move(i);
            resultView.saveRoundResult(i, this.carPositions);
        }

        return resultView;
    }

    private void prepareToRace() {
        for (int i = 0; i < carNames.size(); i++) {
            System.out.println(carNames.get(i));
            Racingcar racingcar = createCar(i, carNames.get(i));
            participateRace(racingcar);
        }
    }

    private void validateTime(int time) {
        if (time < INPUT_ERROR_MIN_NUMBER) {
            throw new IllegalArgumentException("value is small than zero");
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

    private void participateRace(Racingcar racingcar) {
        carPositions.add(racingcar);
    }

    private Racingcar createCar(int number, String carName) {
        return new Racingcar(number, carName);
    }

}