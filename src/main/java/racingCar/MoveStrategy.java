package racingCar;

public class MoveStrategy {
    private static final int DISTANCE_STANDARD = 4;
    public static final int MAX_DISTANCE = 9;
    public static final int MIN_DISTANCE = 0;
    public boolean isMovable(int distance){
        validDistance(distance);
        return distance >= DISTANCE_STANDARD;
    }
    private void validDistance(int distance){
        if(distance > MAX_DISTANCE || MIN_DISTANCE > distance){
            throw new IllegalArgumentException("입력범위를 벗어났습니다.");
        }
    }
}
