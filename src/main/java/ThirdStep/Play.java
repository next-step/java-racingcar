package ThirdStep;

import java.util.List;
import java.util.Random;

public class Play {
    public static void racing(List<Car> cars) {
        System.out.println("실행 결과");

        while (GameSetting.getAttempts() > 0) {
            cars.forEach(car -> {
                if (Play.CanMoveForward()) {
                    car.move();
                }
                car.printLocation();
            });

            System.out.println();
            GameSetting.reduceAttempts();
        }
    }

    private static boolean CanMoveForward() {
        return new Random().nextInt(10) >= 4;
    }
}
