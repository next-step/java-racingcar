package racingcargame;

public class Client {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        RandomOption randomOption = new RandomNumberOption();

        RacingCarGame racingCarGame = new RacingCarGame(inputView.inputNumberOfCars(), inputView.inputCount());
        racingCarGame.startGame(randomOption);

        inputView.close();
    }
}