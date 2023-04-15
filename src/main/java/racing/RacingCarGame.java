package racing;

public class RacingCarGame {

    private static int round = 0;

    public static void start() {
        InputView.input();
        progress(new Cars(InputView.carCount(), InputView.moveCount()));
    }

    public static void progress(Cars cars) {
        for (int i = 0; i < cars.moveCount(); i++) {
            cars = cars.move();
            ResultView.print(cars);
            round += 1;
        }
    }

    public static int getRound() {
        return round;
    }

}
