package domain.car;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        InputView inputView = new InputView();
        List<Car> cars = inputView.carNameQuestion();
        int attemptCount = inputView.attemptCountQuestion();

        CarRacingGame racing = new CarRacingGame(cars);
        racing.start(attemptCount);

        ResultView resultView = new ResultView(racing);
        resultView.print();
    }
}
