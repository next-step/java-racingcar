package ThirdStep;

import java.util.List;

public class CarRacingGame {
    public static void run() {
        GameSetting.setting();
        List<Car> cars = GameSetting.getCars();
        Play.racing(cars);
    }

}
