package racingcar.controller;

import java.util.List;
import racingcar.domain.Movable;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingGame;
import racingcar.domain.Winners;
import racingcar.util.RandomUtil;
import racingcar.view.RacingCarInput;
import racingcar.view.RacingCarOutput;

public class GameLauncher {
    private static final int RANDOM_START = 0;
    private static final int RANDOM_END = 9;
    private static final int END_SIZE = 1;

    private String[] carNameLists;
    private int raceCount;
    private List<RacingCars> racingCarLists;
    private RacingCars racingCars;
    private RacingGame racingGame;

    public void start() {
        inputAll();
        runRaceGame();
        winnerProcess();
    }

    private void inputAll() {
        carNameLists = RacingCarInput.getCarName();
        raceCount = RacingCarInput.getRaceCount();
    }

    private void runRaceGame() {
        final Movable movable = () -> RandomUtil.pickNumberInRange(RANDOM_START, RANDOM_END) >= 4;
        racingCars = new RacingCars(carNameLists);
        racingGame = new RacingGame(racingCars, raceCount);
        racingCarLists = racingGame.moveForwardAll(movable);
        RacingCarOutput.printGameScore(racingCarLists);
    }

    private void winnerProcess() {
        Winners winners = new Winners(racingCarLists.get(racingCarLists.size() - END_SIZE));
        List<String> gameWinner = winners.getWinners();
        RacingCarOutput.printWinnersResult(gameWinner);
    }

}
