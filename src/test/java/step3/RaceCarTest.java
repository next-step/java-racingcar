package step3;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.operation.Operation;
import step3.view.InputView;
import step3.view.ResultView;

public class RaceCarTest {

    @DisplayName("자동차 대수 & 시도할 횟수 입력 테스트")
    @Test
    public void 자동차수_및_시도횟수_입력() {
        InputView iv = new InputView();
        iv.numOfCars("3");
        iv.numberOfAttempts("5");
    }

    @DisplayName("최종 테스트")
    @Test
    public void 경주() {
        InputView inputView = new InputView();
        Operation operation = new Operation();
        int numOfCars = inputView.numOfCars("3");
        int numOfAtp = inputView.numberOfAttempts("5");

        operation.gameStart(numOfAtp, numOfCars);

    }

}
