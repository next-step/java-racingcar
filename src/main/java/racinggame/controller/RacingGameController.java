package racinggame.controller;

import java.util.List;
import racinggame.domain.Judge;
import racinggame.domain.RacingCar;
import racinggame.domain.RacingGame;
import racinggame.service.InputService;
import racinggame.view.GameView;
import racinggame.view.InputView;

public class RacingGameController {

    private static final int NORMAL_EXIT_CODE = 0;
    private final InputView inputView;
    private final InputService inputService;
    private GameView gameView;

    public RacingGameController(InputView inputView, InputService inputService) {
        this.inputView = inputView;
        this.inputService = inputService;
    }

    public List<RacingCar> getRacingCars() {
        List<RacingCar> racingCars;
        String[] carNames;

        while (true) {
            try {
                carNames = inputService.parseCarNames(inputView.inputCarNames());
                racingCars = RacingCar.racingCarOf(carNames);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return racingCars;
    }

    public int getTrial() {
        int trial;

        while (true) {
            try {
                trial = inputService.parseTrial(inputView.inputTrial());
                break;
            } catch (IllegalArgumentException | ArithmeticException e) {
                System.out.println(e.getMessage());
            }
        }

        return trial;
    }

    public void startGame(List<RacingCar> racingCars, int trial) {
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

    private void start(RacingGame racingGame, int trial) {
        for (int i = 0; i < trial; i++) {
            racingGame.progress();
            gameView.saveProgress();
        }
    }

    public void printResult() {
        gameView.printResult();
    }

    public void printWinners(List<RacingCar> racingCars) {
        gameView.printWinners(Judge.getWinners(racingCars));
    }

    public void checkIsRestart() {
        if (isQuit(inputView.inputRestartCommand())) {
            System.exit(NORMAL_EXIT_CODE);
        }
    }

    private boolean isQuit(String command) {
        return command.equals(InputView.QUIT);
    }
}
