package study.step3;


import study.step3.domain.CarRacing;
import study.step3.domain.Circuit;
import study.step3.view.InputView;
import study.step3.view.ResultView;

public class CarRacingMain {
    public static void main(String[] args) {
        Circuit request = requestInput();
        CarRacing carRacing = new CarRacing(request);
        carRacing.start();
        ResultView resultView = new ResultView(carRacing);
        resultView.report();
    }

    private static Circuit requestInput() {
        try {
            return new InputView().request();
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            System.exit(-1);
            throw e;
        }
    }
}
