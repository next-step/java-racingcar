package racing;

public class RacingGame {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        int carCount = InputView.inputCarCount();
        int tryCount = InputView.inputTryCount();

        Cars cars = new Cars(carCount);

        cars.race(tryCount);
    }
}
