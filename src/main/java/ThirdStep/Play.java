package ThirdStep;

import java.util.List;
import java.util.Random;

public class Play {

    public static final int ZERO = 0;
    public static final int RANDOM_NUMBER_BOUND = 10;
    public static final int FORWARD_CRITERIA = 4;

    public static void racing(List<Car> cars, int attempts) {
        if (attempts == ZERO) {
            return;
        }

        cars.forEach(car -> {
            car.move(Play.canMoveForward());
            car.printLocation();
        });

        System.out.println();
        Play.racing(cars, --attempts);
    }

    private static boolean canMoveForward() {
        return new Random().nextInt(RANDOM_NUMBER_BOUND) >= FORWARD_CRITERIA;
    }
}
