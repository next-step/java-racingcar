package step3;

public class CarRacingApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int carCount = inputView.carCount();
        int tryCount = inputView.tryCount();

        RacingGame racingGame = new RacingGame();
        racingGame.readyCar(carCount);

        System.out.println("실행결과");
        for (int i = 0; i < tryCount; i++) {
            ResultView.gameResultView(racingGame.playGame());
            System.out.println();
        }
    }

}
