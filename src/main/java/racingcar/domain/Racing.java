package racingcar.domain;

import racingcar.strategyTest.MoveStrategy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Racing {
    private int MAX_POSITION = 0;

    public void runRacingRound(List<RacingCar> racingCars, MoveStrategy moveStrategy) {
        for (RacingCar racingCar : racingCars) {
            racingCar.tryToMove(moveStrategy);
            updateMaxPosition(racingCar.position());
        }
    }

//    public List<String> findWinner(List<RacingCar> racingCars) {
//        List<Integer> carPositionValues = new ArrayList<>();
//        for (RacingCar racingCar : racingCars) {
//            carPositionValues.add(racingCar.position());
//        }
////        List<Integer>Collections.max(carPositionValues);
//    }
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

    public void findWinner(List<RacingCar> racingCars) {
        List<Integer> carPositions = makeCarPostionList(racingCars);

        int maxPosition = recordMaxPosition(carPositions);


    }

    public void updateMaxPosition(int position) {
        if (position >= MAX_POSITION) {
            MAX_POSITION = position;
        }
    }

    public List<String> makeWinnerList(List<RacingCar> racingCars) {
        List<String> gameWinner = new ArrayList<>();

        for (RacingCar racingCar : racingCars) {
            gameWinner.add(findGameWinner(racingCar));
        }

        while (gameWinner.remove("")) {
        }

        return gameWinner;
    }

    public String findGameWinner(RacingCar racingCar) {
        String winner = "";

        if (racingCar.position() == MAX_POSITION) {
            return racingCar.name();
        }

        return winner;
    }

    public int maxPosition() {
        return MAX_POSITION;
    }
}