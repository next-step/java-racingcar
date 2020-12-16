package step3;

import step3.domain.Racing;
import step3.view.InputView;
import step3.view.ResultView;

public class RacingMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        Racing.INPUT_NUMBER_OF_CAR_CREATE = inputView.input("자동차 대수는 몇 대 인가요?");
        Racing.INPUT_NUMBER_OF_MOVE = inputView.input("시도할 회수는 몇 회 인가요?");

        Racing racing = new Racing();
        racing.carRegistration(Racing.INPUT_NUMBER_OF_CAR_CREATE);
        racing.numberOfCarMove();

        resultView.carPositionPrints(racing.car);
    }

}
