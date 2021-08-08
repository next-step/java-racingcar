package racing_winner.domain;

import racing_winner.strategy.CarStrategy;
import racing_winner.strategy.InputCarStrategy;
import racing_winner.strategy.RacingStrategy;

public final class Car {
    private static final CarStrategy CAR_STRATEGY = new InputCarStrategy();

    private String name;
    private int distance;

    public Car(final String name) {
        if(!CAR_STRATEGY.isUsable(name)){
            throw new IllegalArgumentException("이름은 1-5글자 사이로 입력해주세요");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void move(final RacingStrategy racingStrategy){
        if(racingStrategy.isMovable()){
            distance++;
        }
    }

    public boolean compareDistance(final int baseDistance){
        return distance >= baseDistance;
    }

    public int findFartherDistance(final int baseDistance){
        if (compareDistance(baseDistance)) {
            return distance;
        }
        return baseDistance;
    }
}
