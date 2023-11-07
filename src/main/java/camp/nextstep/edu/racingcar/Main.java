package camp.nextstep.edu.racingcar;

public class Main {

    public static void main(String[] args) {
        RacingInputView racingInputView = new RacingInputViewImpl();
        RacingOutputView racingOutputView = new RacingOutputViewImpl();

        RacingGameConsole console = new RacingGameConsole(racingInputView, racingOutputView);
        console.start();
    }
}
