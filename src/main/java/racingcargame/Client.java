package racingcargame;

public class Client {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingCarGame racingCarGame = new RacingCarGame(inputView.inputNumberOfCars(), inputView.inputCount());
        racingCarGame.startGame();
    }
}
