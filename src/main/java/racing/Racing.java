package racing;

import java.util.List;
import java.util.Random;

public class Racing {

    public static final int BOUND = 9;
    private static final Random random = new Random();

    private Racing() {
    }

    private static int random() {
        return random.nextInt(BOUND);
    }

    public static void goRacing(List<Car> cars, RaceInfo raceInfo) {
        int trials = raceInfo.trialData();
        System.out.println("\n실행 결과");

        for (int i = 0; i < trials; i++) {
            drive(cars);
            System.out.println();
        }
    }

    private static void drive(List<Car> cars) {
        cars.forEach(car -> {
            car.move(random());
            ResultView.status(car);
        });
    }

}
