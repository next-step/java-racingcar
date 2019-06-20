package step3;

class RacingGameWithNameApplication {

    private InputView input;

    protected RacingGameWithNameApplication() {
        this.input = new InputView();
    }

    public static void main(String[] args) {

        RacingGameWithNameApplication app = new RacingGameWithNameApplication();
        int carNumber = app.input.inputCarNumber();
        int tryCount = app.input.inputTryCount();

        RacingGameWithName racingGamewithName = new RacingGameWithName();
        racingGamewithName.setInitPosition(carNumber);

        System.out.println("실행결과");

        while (tryCount-- > 0) {
            racingGamewithName.startRacing(carNumber);
            racingGamewithName.resultView();
        }
    }
}
