package study.step3;


public class CarRacingMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        CarRacing carRacing = new CarRacing(inputView.request(), resultView);
        carRacing.start();
        resultView.report();
    }
}
