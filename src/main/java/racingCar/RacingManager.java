package racingCar;

public class RacingManager {
    static private final int THRESHOLD = 4;

    static public boolean isMovableNumber(int number){
        return number >= THRESHOLD;
    }

}
