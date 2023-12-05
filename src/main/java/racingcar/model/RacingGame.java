package racingcar.model;

import racingcar.model.movestrategy.MoveStrategy;
import racingcar.model.movestrategy.RandomVarMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.*;

public class RacingGame {
    private static final String ERR_NEGATIVE_NUMBER = "Negative numbers are not allowed.";
    private final List<RacingCar> cars;
    private final Referee referee = new Referee();

    public RacingGame(List<String> carNameList, int roundNumber) {
        // validation
        validateRoundNumber(roundNumber);

        // setting
        this.cars = makeCars(carNameList);
    }

    private void validateRoundNumber(int roundNumber) {
        if (roundNumber < 0) {
            throw new RuntimeException(ERR_NEGATIVE_NUMBER);
        }
    }

    private List<RacingCar> makeCars(List<String> carNameList) {
        int carNumber = carNameList.size();

        RacingCar[] cars = new RacingCar[carNumber];
        for (int i = 0; i < carNumber; i++) {
            RacingCar newCar = new RacingCar(carNameList.get(i));
            cars[i] = newCar;
        }

        return Arrays.asList(cars);
    }


    public void playOneRound(MoveStrategy moveStrategy) {
        for (RacingCar car : this.cars) {
            car.moveOrStop(moveStrategy);
        }
    }


    public List<RacingCar> cars() {
        return this.cars;
    }

    public List<RacingCar> winners() {
        return referee.findWinner(this.cars);
    }
}
