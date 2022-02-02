package racinggame.controller;

import racinggame.domain.Judge;
import racinggame.domain.RacingCars;
import racinggame.domain.RacingGame;
import racinggame.domain.Trial;
import racinggame.exception.InputBlankException;
import racinggame.exception.LackOfPlayerException;
import racinggame.exception.NameLengthOverException;
import racinggame.view.GameView;
import racinggame.view.InputView;

public class RacingGameController {

    private static final int NORMAL_EXIT_CODE = 0;
    private static final String QUIT = "q";

    public RacingGameController() {}

    public RacingCars getRacingCars() {
        RacingCars racingCars;

        while (true) {
            try {
                racingCars = new RacingCars(InputView.inputCarNames());
                break;
            } catch (NameLengthOverException e) {
                InputView.printErrorMessage(e.getMessage());
            }
        }

        return racingCars;
    }

    public Trial getTrial() {
        Trial trial;

        while (true) {
            try {
                trial = new Trial(InputView.inputTrial());
                break;
            } catch (InputBlankException | NumberFormatException e) {
                InputView.printErrorMessage(e.getMessage());
            }
        }
        return trial;
    }

    public void startGame(RacingCars racingCars, final Trial trial) {
        RacingGame racingGame;

        while (true) {
            try {
                racingGame = new RacingGame(racingCars);
                break;
            } catch (LackOfPlayerException e) {
                InputView.printErrorMessage(e.getMessage());
                racingCars = getRacingCars();
            }
        }
        GameView.init(racingCars);
        start(racingGame, trial);
    }

    private void start(final RacingGame racingGame, final Trial trial) {
        for (int i = 0; i < trial.getValue(); i++) {
            racingGame.progress();
            GameView.saveProgress(racingGame.getRacingCars());
        }
    }

    public void printResult() {
        GameView.printResult();
    }

    public void printWinners(final RacingCars racingCars) {
        GameView.printWinners(Judge.getWinners(racingCars));
    }

    public void checkIsRestart() {
        if (isQuit(InputView.inputRestartCommand())) {
            System.exit(NORMAL_EXIT_CODE);
        }
    }

    private boolean isQuit(final String command) {
        return QUIT.equals(command);
    }
}
