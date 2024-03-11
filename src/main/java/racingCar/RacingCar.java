package racingCar;

import static racingCar.MoveStrategy.MAX_DISTANCE;
import static racingCar.MoveStrategy.MIN_DISTANCE;

public class RacingCar {

    private static final int START_LOCATION = 0;
    private final MoveStrategy strategy;
    int location;

    public RacingCar(MoveStrategy strategy) {
        this.strategy = strategy;
        this.location = START_LOCATION;
    }

    public int findCurrentLocation() {
        return this.location;
    }

    public void move(int distance) {
        validDistance(distance);
        if (strategy.isMovable(distance)) {
            this.location++;
        }
    }
    private void validDistance(int distance){
        if(distance > MAX_DISTANCE  || MIN_DISTANCE > distance){
            throw new IllegalArgumentException("입력범위를 벗어났습니다.");
        }
    }
}
