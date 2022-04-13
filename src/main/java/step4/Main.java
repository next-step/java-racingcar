package step4;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        InputView inputView = new InputView();
        List<Car> cars = inputView.carNameQuestion();
        int attemptCount = inputView.attemptCountQuestion();

        Racing racing = new Racing(cars);
        racing.play(attemptCount);

        ResultView resultView = new ResultView(racing);
        resultView.print();
    }
}
