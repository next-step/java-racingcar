package racingcar;

public class GameService {
    public static void start(Cars cars, int playCount) {
        int startCount = 0;
        while ( startCount != playCount) {
            cars.play();
            ResultView.printCars(cars);
            System.out.println("\n");
            startCount++;
        }
    }
}
