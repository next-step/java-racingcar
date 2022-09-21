package ThirdStep;

import java.util.List;
import java.util.Random;

public class CarRacingGame {
    public static void racing() {
        GameSetting.setting();

        List<Car> cars = GameSetting.getCars();
        while (GameSetting.getAttempts() > 0) {
            cars.forEach(car -> car.move(CarRacingGame.CanForward()));
            GameSetting.reduceAttempts();
        }
    }

    public static boolean CanForward() {
        return new Random().nextInt(10) >= 4;
    }

}
