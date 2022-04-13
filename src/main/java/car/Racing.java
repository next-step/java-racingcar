package car;

import java.util.List;

public class Racing {
    public static void main(String[] args) throws Exception {
        InputView inputView = new InputView();
        List<Car> cars = inputView.carNameQuestion();
        int attemptCount = inputView.attemptCountQuestion();

        CarRacing racing = new CarRacing(cars);
        racing.play(attemptCount);

        ResultView resultView = new ResultView(racing);
        resultView.print();
    }
}
