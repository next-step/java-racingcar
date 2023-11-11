package racingcar;

import racingcar.application.RacingCarGameService;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;
import racingcar.ui.dto.RacingGameRequest;
import racingcar.ui.dto.RacingGameResponse;


public class RacingCarGame {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        gameStart(inputView.inputCars(), inputView.inputGameTurn());
    }

    private static void gameStart(String[] carNames, int endTurn) {
        System.out.println("게임 시작");
        RacingCarGameService service = new RacingCarGameService();
        RacingGameResponse response = service.start(new RacingGameRequest(carNames, endTurn));
        ResultView resultView = new ResultView();
        resultView.showRacingCarGame(response);
        System.out.println("게임 종료");
    }
}
