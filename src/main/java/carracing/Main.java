package carracing;

import carracing.application.CarRacing;
import carracing.domain.RaceResult;
import carracing.view.InputView;
import carracing.view.ResultView;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        CarRacing carRacing = new CarRacing();
        List<RaceResult> results = carRacing
            .race(inputView.inputCarCount(), inputView.inputTryCount());
        ResultView resultView = new ResultView();
        resultView.showResult(results);
    }
}
