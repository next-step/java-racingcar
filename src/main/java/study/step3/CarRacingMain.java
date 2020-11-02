package study.step3;


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
