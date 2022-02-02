package racinggame;

import racinggame.controller.RacingGameController;
import racinggame.domain.RacingCars;
import racinggame.domain.Trial;
import racinggame.domain.vo.InputVo;
import racinggame.domain.vo.WinnersVo;
import racinggame.view.GameView;
import racinggame.view.InputView;

public class Application {

    public static void main(String[] args) {

        final RacingGameController controller = new RacingGameController();

        while (true) {
            InputVo inputVo = new InputVo(InputView.inputCarNames(), InputView.inputTrial());

            RacingCars racingCars = controller.getRacingCars(inputVo.getCarNames());
            Trial trial = controller.getTrial(inputVo.getTrial());

            controller.startGame(racingCars, trial);
            WinnersVo winnersVo = controller.getWinners(racingCars);
            GameView.printResult();
            GameView.printWinners(winnersVo);

            controller.checkIsRestart();
        }
    }
}
