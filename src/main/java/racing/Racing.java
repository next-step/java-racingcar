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

    public static void goRacing(List<Car> cars, int trials) {
        for (int i = 0; i < trials; i++) {
            drive(cars);
            System.out.println();
        }
    }

    private static void drive(List<Car> cars) {
        for (Car car : cars) {
            car.move(random());
            System.out.println(ResultView.status(car));
        }
    }

}
