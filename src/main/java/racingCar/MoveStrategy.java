package racingCar;

public class MoveStrategy {
    private static final int DISTANCE_STANDARD = 4;
    public boolean isMovable(int distance){
        return distance >= DISTANCE_STANDARD;
    }
}
