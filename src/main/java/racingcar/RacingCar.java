package racingcar;

public class RacingCar {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.inputCarAmount();
        inputView.inputTryAmount();

        Game game = new Game(inputView.getCarAmount());
        OutputView.printExecutionResult();
        for (int i = 0; i < inputView.getTryAmount(); i++) {
            game.play();
            OutputView.printCarPosition(game.getCars());
        }
    }
}
