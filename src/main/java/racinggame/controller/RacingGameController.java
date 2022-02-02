package racinggame.controller;

import racinggame.domain.Judge;
import racinggame.domain.RacingCars;
import racinggame.domain.RacingGame;
import racinggame.domain.Trial;
import racinggame.domain.vo.WinnersVo;
import racinggame.exception.InputBlankException;
import racinggame.exception.LackOfPlayerException;
import racinggame.exception.NameLengthOverException;
import racinggame.view.GameView;
import racinggame.view.InputView;

public class RacingGameController {

    private static final int NORMAL_EXIT_CODE = 0;
    private static final String QUIT = "q";

    public RacingGameController() {}

    public RacingCars getRacingCars(String inputCarNames) {
        RacingCars racingCars;

        while (true) {
            try {
                racingCars = new RacingCars(inputCarNames);
                break;
            } catch (NameLengthOverException e) {
                InputView.printErrorMessage(e.getMessage());
                inputCarNames = InputView.inputCarNames();
            }
        }

        return racingCars;
    }

    public Trial getTrial(String inputTrial) {
        Trial trial;

        while (true) {
            try {
                trial = new Trial(inputTrial);
                break;
            } catch (InputBlankException | NumberFormatException e) {
                InputView.printErrorMessage(e.getMessage());
                inputTrial = InputView.inputTrial();
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
                racingCars = getRacingCars(InputView.inputCarNames());
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

    public WinnersVo getWinners(RacingCars racingCars) {
        return new WinnersVo(Judge.getWinners(racingCars));
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
