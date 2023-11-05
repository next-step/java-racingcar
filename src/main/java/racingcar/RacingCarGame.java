package racingcar;

import racingcar.application.RacingCarGameService;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;


public class RacingCarGame {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        gameStart(inputView.inputCarNumber(), inputView.inputGameTurn());
    }

    private static void gameStart(int carNumber, int endTurn) {
        System.out.println("게임 시작");
        RacingCarGameService service = new RacingCarGameService();
        service.initializeCars(carNumber);
        ResultView resultView = new ResultView(service);
        resultView.showRacingCarGame(endTurn);
        System.out.println("게임 종료");
    }
}
