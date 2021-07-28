package racingCar;

public class RacingManager {
    private final int THRESHOLD = 4;

    public boolean isMovableNumber(int number){
        return number >= THRESHOLD;
    }

}
