package racingcar.domain;

import racingcar.strategyTest.MoveStrategy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Racing {

    public void runRacingRound(List<RacingCar> racingCars, MoveStrategy moveStrategy) {
        for (RacingCar racingCar : racingCars) {
            racingCar.tryToMove(moveStrategy);
        }
    }

    public List<Integer> makeCarPostionList(List<RacingCar> racingCars) {
        List<Integer> carPositions = new ArrayList<>();

        for(RacingCar racingcar : racingCars) {
            carPositions.add(racingcar.position());
        }

        return carPositions;
    }

    public int recordMaxPosition(List<Integer> carPositions) {
        return Collections.max(carPositions);
    }

    public List<String> makeWinnerList(List<RacingCar> racingCars) {
        List<Integer> carPositions = makeCarPostionList(racingCars);

        int maxPosition = recordMaxPosition(carPositions);

        List<String> gameWinner = new ArrayList<>();

        for (RacingCar racingCar : racingCars) {
            if(racingCar.position() == maxPosition) gameWinner.add(racingCar.name());
        }

        return gameWinner;
    }

}