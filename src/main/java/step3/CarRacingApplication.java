package step3;

public class CarRacingApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int carCount = inputView.carCount();
        int tryCount = inputView.tryCount();

        RacingGame racingGame = new RacingGame();
        racingGame.readyCar(carCount);
        racingGame.playGame(tryCount);
    }

}
