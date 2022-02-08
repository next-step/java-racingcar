package racinggame;

import racinggame.domain.Judge;
import racinggame.domain.RacingCars;
import racinggame.domain.RacingGame;
import racinggame.domain.Trial;
import racinggame.domain.vo.InputVo;
import racinggame.domain.vo.WinnersVo;
import racinggame.exception.InputBlankException;
import racinggame.exception.LackOfPlayerException;
import racinggame.exception.NameLengthOverException;
import racinggame.util.Retry;
import racinggame.view.GameView;
import racinggame.view.InputView;

public class RacingGameApplication {

    private static final int NORMAL_EXIT_CODE = 0;
    private static final String QUIT = "q";

    public static void main(String[] args) {

        while (true) {
            Retry.retry(() -> {
                        InputVo inputVo = new InputVo(InputView.inputCarNames(), InputView.inputTrial());

                        Trial trial = getTrial(inputVo.getTrial());
                        RacingCars racingCars = getRacingCars(inputVo.getCarNames());

                        RacingGame racingGame = new RacingGame(racingCars);
                        startGame(racingGame, trial);

                        WinnersVo winnersVo = getWinners(racingCars);
                        GameView.printResult();
                        GameView.printWinners(winnersVo);

                        checkIsRestart();
                        return null;
                    },
                    5,
                    NameLengthOverException.class,
                    InputBlankException.class, LackOfPlayerException.class);
        }
    }

    private static RacingCars getRacingCars(String inputCarNames) {
        return new RacingCars(inputCarNames);
    }

    public static Trial getTrial(String inputTrial) {
        return new Trial(inputTrial);
    }

    public static void startGame(final RacingGame racingGame, final Trial trial) {
        GameView.init(racingGame.getRacingCars());
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
