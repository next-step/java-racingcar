package step5.controller;

import step5.service.Racing;
import step5.view.InputView;
import step5.view.ResultView;

public class RacingController {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        Racing racing = new Racing(inputView.inputString("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분 합니다."), inputView.inputInt("시도할 회수는 몇 회 인가요?"));

        resultView.carPositionPrints(racing.getCarList());
        resultView.winnerNamePrints(racing.getWinners());
    }
}
