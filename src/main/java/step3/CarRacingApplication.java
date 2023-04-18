package step3;

public class CarRacingApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int carCount = inputView.carCount();
        inputView.tryCount();
        System.out.println("\n");

        RacingGame racingGame = new RacingGame();
        racingGame.readyCar(carCount);
    }

}
