package racinggame.domain.car;

import racinggame.domain.strategy.MovableStrategy;

public class RacingCar {

    private MovableStrategy movableStrategy;
    private String name;
    private int position;

    private RacingCar(String name, MovableStrategy movableStrategy) {
        validateCarName(name);
        validateMovableStrategy(movableStrategy);

        this.name = name;
        this.movableStrategy = movableStrategy;
    }

    public static RacingCar newInstance(String name, MovableStrategy movableStrategy) {
        return new RacingCar(name, movableStrategy);
    }

    private void validateCarName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 존재하지 않습니다.");
        }
    }

    private void validateMovableStrategy(MovableStrategy movableStrategy) {
        if (movableStrategy == null) {
            throw new IllegalArgumentException("이동 전략이 존재하지 않습니다.");
        }
    }

    public void move() {
        if (movableStrategy.isMovable()) {
            this.position++;
        }
    }

    public void setMovableStrategy(MovableStrategy movableStrategy) {
        validateMovableStrategy(movableStrategy);
        this.movableStrategy = movableStrategy;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return this.position;
    }
}
