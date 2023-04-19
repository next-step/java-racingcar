package step3;

public class CarRacingApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int carCount = inputView.carCount();
        int tryCount = inputView.tryCount();

        RacingGame racingGame = new RacingGame();
        racingGame.readyCar(carCount);

        ResultView.gameResultStart();
        for (int i = 0; i < tryCount; i++) {
            racingGame.playGame();
            ResultView.gameResultView(racingGame.getCars());
            System.out.println();
        }
    }

}
