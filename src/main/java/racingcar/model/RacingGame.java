package racingcar.model;

import racingcar.model.movestrategy.MoveStrategy;
import racingcar.model.movestrategy.RandomVarMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.*;

public class RacingGame {
    private static final String ERR_NEGATIVE_NUMBER = "Negative numbers are not allowed.";

    private final Referee referee = new Referee();
    private List<RacingCar> cars;


    public RacingGame(List<String> carNameList, int roundNumber) {
        // validation
        validateRoundNumber(roundNumber);

        // setting
        MoveStrategy defaultMoveStrategy = new RandomVarMoveStrategy();
        this.cars = makeCars(defaultMoveStrategy, carNameList);
    }

    public RacingGame(MoveStrategy moveStrategy, List<String> carNameList, int roundNumber) {
        // validation
        validateRoundNumber(roundNumber);

        // setting
        this.cars = makeCars(moveStrategy, carNameList);
    }

    private void validateRoundNumber(int roundNumber) {
        if (roundNumber < 0) {
            throw new RuntimeException(ERR_NEGATIVE_NUMBER);
        }
    }

    private List<RacingCar> makeCars(MoveStrategy moveStrategy, List<String> carNameList) {
        int carNumber = carNameList.size();

        RacingCar[] cars = new RacingCar[carNumber];
        for (int i=0; i<carNumber; i++) {
            RacingCar newCar = new RacingCar(moveStrategy, carNameList.get(i));
            cars[i] = newCar;
        }

        return Arrays.asList(cars);
    }


    public void playOneRound() {
        for (RacingCar car : this.cars) {
            car.moveOrStop();
        }
    }


    public List<RacingCar> cars() {
        return this.cars;
    }

    public List<RacingCar> winners() {
        return referee.findWinner(this.cars);
    }
}
