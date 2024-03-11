package racing.view;

import static racing.view.InputView.inputCarCount;
import static racing.view.InputView.inputGameCount;
import static racing.view.ResultView.showResult;

public class Application {
    public static void main(String[] args) {
        int participants = inputCarCount();
        int rounds = inputGameCount();

        // 로직 실행부

        // 출력부
        showResult();
    }
}
