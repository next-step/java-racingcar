package racing;

import racing.domain.CarRacing;
import racing.domain.RandomMovableRule;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.List;

public class RacingApplication {

    public static void main(String[] args) {
        List<String> names = InputView.getCarNames();
        int times = InputView.getTimes();

        CarRacing carRacing = new CarRacing(names, times, new RandomMovableRule());
        carRacing.run();

        ResultView.printResult(carRacing);
    }
}
