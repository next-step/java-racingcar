package racingCar.Utils;

import racingCar.Entity.RacingCar;

public class MoveUtils {
    public static void setPosition(RacingCar racingCar,int randomNum) {
        if (isGo(randomNum)) {
            int nowPosition = racingCar.getPosition();
            racingCar.setPosition(nowPosition + 1);
        }
    }

    private static boolean isGo(int randomNum) {
        return randomNum >= 4;
    }
}
