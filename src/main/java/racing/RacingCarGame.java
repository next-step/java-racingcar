package racing;

public class RacingCarGame {

    public static void start() {
        InputView.input();
        Cars cars = new Cars(InputView.carNames(), InputView.moveCount());

        ResultView.printTitle();
        progress(cars);
        ResultView.showWinner(cars);
    }

    public static void progress(Cars cars) {
        for (int i = 0; i < cars.moveCount(); i++) {
            cars = cars.move();
            ResultView.printRace(cars);
        }
    }

}
