package step4;

class RacingGameWinnerApplication {

    private InputView input;
    private ResultView result;
    private RacingGameWinner racingGameWinner;

    private RacingGameWinnerApplication() {
        this.input = new InputView();
        this.result = new ResultView();
        this.racingGameWinner = new RacingGameWinner();
    }

    public static void main(String[] args) {

        RacingGameWinnerApplication app = new RacingGameWinnerApplication();

        String[] carName = app.input.inputCarName();
        int carNumber = carName.length;
        int tryCount = app.input.inputTryCount();

        app.racingGameWinner.setInitPosition(carNumber);

        System.out.println("실행결과");

        while (tryCount-- > 0) {
            app.racingGameWinner.startRacing(carNumber);
            app.result.racingView(app.racingGameWinner.carPositions, carName);
        }
        app.result.findMaxScoreWinner(app.racingGameWinner.carPositions, carName);
    }
}
