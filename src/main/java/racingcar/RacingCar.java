package racingcar;

public class RacingCar {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.inputCarAmount();
        inputView.inputTryAmount();

        Game game = new Game(inputView.getCarAmount(), inputView.getTryAmount());
        game.start();
    }
}
