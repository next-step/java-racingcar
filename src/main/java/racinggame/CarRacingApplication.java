package racinggame;

public class CarRacingApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String carName = inputView.carsName();

        String[] carsName = Util.splitCarName(carName);
        int tryCount = inputView.tryCount();

        RacingGame racingGame = new RacingGame();
        racingGame.readyCar(carsName);

        ResultView.gameResultStart();
        for (int i = 0; i < tryCount; i++) {
            racingGame.playGame();
            ResultView.gameResultView(racingGame.getCars());
            System.out.println();
        }
    }

}
