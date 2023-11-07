package camp.nextstep.edu.racingcar;

public class RacingGameConsole {

    private static final DriveStrategy DRIVE_STRATEGY = new SixtyPercentDriveStrategy();

    private final RacingInputView input;
    private final RacingOutputView output;

    public RacingGameConsole(RacingInputView input, RacingOutputView output) {
        this.input = input;
        this.output = output;
    }

    public void start() {
        int carAmount = inputCarAmount();
        int roundAmount = inputRoundAmount();

        RacingGame racingGame = new RacingGame(DRIVE_STRATEGY, carAmount, roundAmount);
        RacingGameResult gameResult = racingGame.play();
        output.printGameResult(gameResult);
    }

    private int inputCarAmount() {
        output.printRequestCarAmount();
        return input.readCarAmount();
    }

    private int inputRoundAmount() {
        output.printRequestRoundAmount();
        return input.readRoundAmount();
    }
}
