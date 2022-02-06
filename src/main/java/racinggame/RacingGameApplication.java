package racinggame;

import racinggame.domain.Judge;
import racinggame.domain.RacingCars;
import racinggame.domain.RacingGame;
import racinggame.domain.Retry;
import racinggame.domain.Trial;
import racinggame.domain.vo.InputVo;
import racinggame.domain.vo.WinnersVo;
import racinggame.exception.InputBlankException;
import racinggame.exception.LackOfPlayerException;
import racinggame.exception.NameLengthOverException;
import racinggame.view.GameView;
import racinggame.view.InputView;

public class RacingGameApplication {

    private static final int NORMAL_EXIT_CODE = 0;
    private static final String QUIT = "q";

    public static void main(String[] args) {

        while (true) {
            InputVo inputVo = new InputVo(InputView.inputCarNames(), InputView.inputTrial());

            RacingCars racingCars = getRacingCars(inputVo.getCarNames());
            Trial trial = getTrial(inputVo.getTrial());

            startGame(racingCars, trial);
            WinnersVo winnersVo = getWinners(racingCars);
            GameView.printResult();
            GameView.printWinners(winnersVo);

            checkIsRestart();
        }
    }

    public static RacingCars getRacingCars(String inputCarNames) {
        RacingCars racingCars;
        try {
            racingCars = new RacingCars(inputCarNames);
        } catch (NameLengthOverException | InputBlankException e) {
            System.out.println(e.getMessage());
            racingCars = Retry.createRacingCarsUntilValid();
        }

        return racingCars;
    }

    public static Trial getTrial(String inputTrial) {
        Trial trial;
        try {
            trial = new Trial(inputTrial);
        } catch (InputBlankException | NumberFormatException e) {
            System.out.println(e.getMessage());
            trial = Retry.createTrialUntilValid();
        }

        return trial;
    }

    public static void startGame(RacingCars racingCars, final Trial trial) {
        RacingGame racingGame;
        try {
            racingGame = new RacingGame(racingCars);
        } catch (LackOfPlayerException e) {
            System.out.println(e.getMessage());
            racingGame = new RacingGame(Retry.createRacingCarsUntilValid());
        }

        GameView.init(racingCars);
        start(racingGame, trial);
    }

    private static void start(final RacingGame racingGame, final Trial trial) {
        int count = trial.getValue();
        for (int i = 0; i < count; i++) {
            racingGame.progress();
            GameView.saveProgress(racingGame.getRacingCars());
        }
    }

    public static WinnersVo getWinners(RacingCars racingCars) {
        return new WinnersVo(Judge.getWinners(racingCars));
    }

    public static void checkIsRestart() {
        if (isQuit(InputView.inputRestartCommand())) {
            System.exit(NORMAL_EXIT_CODE);
        }
    }

    private static boolean isQuit(final String command) {
        return QUIT.equals(command);
    }
}
