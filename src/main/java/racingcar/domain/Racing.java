package racingcar.domain;

import racingcar.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private int MAX_POSITION = 0;
    private List<RacingCar> racingCars;

    public Racing(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public void runRacingRound(MoveStrategy moveStrategy) {
        for (RacingCar racingCar : this.racingCars) {
            racingCar.tryToMove(moveStrategy);
            updateMaxPosition(racingCar.position());
        }
    }

    public void updateMaxPosition(int position) {
        if (position >= MAX_POSITION) {
            MAX_POSITION = position;
        }
    }

    public List<String> makeWinnerList() {
        List<String> gameWinner = new ArrayList<>();

        for (RacingCar racingCar : this.racingCars) {
            gameWinner.add(findGameWinner(racingCar));
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