package racingcargame;

public class Client {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        RandomOption randomOption = new RandomNumberOption();

        try {
            RacingCarGame racingCarGame = new RacingCarGame(inputView.inputNameOfCars(), inputView.inputCount());
            racingCarGame.startGame(randomOption);
            racingCarGame.showWinner();

            inputView.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}