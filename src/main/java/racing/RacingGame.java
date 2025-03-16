package racing;

public class RacingGame {

    public static void run() {
        int carCount = 3;
        int tryCount = 5;

        Cars cars = new Cars(carCount);

        cars.race(tryCount);
    }
}
