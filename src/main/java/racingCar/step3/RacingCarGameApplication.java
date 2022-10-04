package racingCar.step3;

public class RacingCarGameApplication {

    public static void main(String[] args) {
        InputView keyboardInput = new InputView();
        ResultView printer = new ResultView();

        RacingGame game = new RacingGame(keyboardInput, printer);
        game.start();
    }
}