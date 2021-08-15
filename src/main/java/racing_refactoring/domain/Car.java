package racing_refactoring.domain;

import racing_refactoring.strategy.CarStrategyImpl;
import racing_refactoring.strategy.CarStrategy;
import racing_refactoring.strategy.RacingStrategy;

public final class Car {

    private final static CarStrategy CAR_STRATEGY = new CarStrategyImpl();

    private String name;
    private int distance;

    public Car(final String name) {
        if(CAR_STRATEGY.underMinLength(name) || CAR_STRATEGY.overMaxLength(name)){
            throw new IllegalArgumentException("이름은 한글자 이상, 5글자 이하로 입력되어야합니다.");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public Car move(final RacingStrategy racingStrategy){
        if(racingStrategy.isMovable()){
            distance++;
        }
        return this;
    }

    public boolean compareDistance(final int target){
        return distance == target;
    }

    public int findFartherDistance(int target) {
        return Math.max(target, distance);
    }
}
