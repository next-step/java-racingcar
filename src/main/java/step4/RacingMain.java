package step4;

import step4.domain.Racing;
import step4.view.InputView;
import step4.view.ResultView;

public class RacingMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        Racing racing = new Racing();
        racing.setCars(Racing.registerCars(inputView.inputString("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분 합니다.")));
        racing.numberOfCarMove(inputView.inputInt("시도할 회수는 몇 회 인가요?"));

        resultView.carPositionPrints(racing.getCarList());
        resultView.winnerNamePrints(racing.getWinners());
    }
}
