package study.step3;

import study.step3.domain.CarRacing;
import study.step3.domain.Circuit;
import study.step3.view.InputView;
import study.step3.view.ResultView;

public class CarRacingController {
    void invoke() {
        Circuit circuit = makeInputView().request();

        CarRacing carRacing = makeRacing(circuit);
        carRacing.start();

        makeResultView(carRacing).report();
    }

    protected InputView makeInputView() {
        return new InputView();
    }

    protected ResultView makeResultView(CarRacing carRacing) {
        return new ResultView(carRacing);
    }

    protected CarRacing makeRacing(Circuit request) {
        return new CarRacing(request);
    }
}
