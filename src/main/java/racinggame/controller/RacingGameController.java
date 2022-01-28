package racinggame.controller;

import racinggame.domain.Judge;
import racinggame.domain.RacingCars;
import racinggame.domain.RacingGame;
import racinggame.domain.Trial;
import racinggame.view.GameView;
import racinggame.view.InputView;

public class RacingGameController {

    private static final int NORMAL_EXIT_CODE = 0;
    private static final String QUIT = "q";
    private final InputView inputView;
    private GameView gameView;

    public RacingGameController(InputView inputView) {
        this.inputView = inputView;
    }

    public RacingCars getRacingCars() {
        RacingCars racingCars;

        while (true) {
            try {
                racingCars = new RacingCars(inputView.inputCarNames());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return racingCars;
    }

    public Trial getTrial() {
        Trial trial;

        while (true) {
            try {
                trial = new Trial(inputView.inputTrial());
                break;
            } catch (IllegalArgumentException | ArithmeticException e) {
                System.out.println(e.getMessage());
            }
        }
        return trial;
    }

    public void startGame(RacingCars racingCars, Trial trial) {
        RacingGame racingGame;

        while (true) {
            try {
                racingGame = new RacingGame(racingCars);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                racingCars = getRacingCars();
            }
        }
        gameView = new GameView(racingCars);
        start(racingGame, trial);
    }

    private void start(RacingGame racingGame, Trial trial) {
        for (int i = 0; i < trial.getValue(); i++) {
            racingGame.progress();
            gameView.saveProgress();
        }
    }

    public void printResult() {
        gameView.printResult();
    }

    public void printWinners(RacingCars racingCars) {
        gameView.printWinners(Judge.getWinners(racingCars));
    }

    public void checkIsRestart() {
        if (isQuit(inputView.inputRestartCommand())) {
            System.exit(NORMAL_EXIT_CODE);
        }
    }

    private boolean isQuit(String command) {
        return QUIT.equals(command);
    }
}
