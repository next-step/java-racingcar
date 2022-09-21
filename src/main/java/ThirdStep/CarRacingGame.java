package ThirdStep;

import java.util.List;

public class CarRacingGame {
    public static void run() {
        GameSetting.setting();
        List<Car> cars = GameSetting.getCars();

        System.out.println("실행 결과");
        Play.racing(cars, GameSetting.getAttempts());
    }

}
