package racingcar;

import racingcar.ui.InputView;
import racingcar.ui.RacingGameController;
import racingcar.ui.ResultView;
import racingcar.ui.dto.RacingGameRequest;
import racingcar.ui.dto.RacingGameResponse;


public class RacingCarGame {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        gameStart(inputView.inputCarNumber(), inputView.inputGameTurn());
    }

    private static void gameStart(int carNumber, int endTurn) {
        System.out.println("게임 시작");
        RacingGameController controller = new RacingGameController(new RacingGameRequest(carNumber));
        ResultView resultView = new ResultView(controller);
        for (int currentTurn=1; currentTurn <= endTurn; currentTurn++) {
            RacingGameResponse response = controller.gameStart();
            resultView.showRacingCarGame(currentTurn, response);
        }
        System.out.println("게임 종료");
    }
}
