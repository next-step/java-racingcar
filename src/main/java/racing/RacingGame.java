package racing;

public class RacingGame {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        String[] carNames = InputView.inputCarNames();
        int tryCount = InputView.inputTryCount();

        Cars cars = new Cars(carNames);

        cars.race(tryCount);
    }
}
