package ThirdStep;

import java.util.List;

public class Play {

    public static final int ZERO = 0;

    public static void racing(List<Car> cars, int attempts) {
        if (attempts == ZERO) {
            return;
        }

        cars.forEach(car -> {
            car.move(RandomMovingCondition.create());
            car.printLocation();
        });

        System.out.println();
        Play.racing(cars, --attempts);
    }
}
