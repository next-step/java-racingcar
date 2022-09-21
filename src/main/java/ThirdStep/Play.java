package ThirdStep;

import java.util.List;
import java.util.Random;

public class Play {
    public static void racing(List<Car> cars, int attempts) {
        if (attempts == 0) {
            return;
        }

        cars.forEach(car -> {
            car.move(Play.CanMoveForward());
            car.printLocation();
        });

        System.out.println();
        Play.racing(cars, --attempts);
    }

    private static boolean CanMoveForward() {
        return new Random().nextInt(10) >= 4;
    }
}
