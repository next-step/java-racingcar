package racinggame.car;

public class RacingCar {

    private final MovableStrategy movableStrategy;
    private String name;
    private int position;

    private RacingCar(String name, MovableStrategy movableStrategy) {
        validateRacingCar(name, movableStrategy);
        this.name = name;
        this.movableStrategy = movableStrategy;
    }

    public static RacingCar newInstance(String name, MovableStrategy movableStrategy) {
        return new RacingCar(name, movableStrategy);
    }

    private void validateRacingCar(String name, MovableStrategy movableStrategy) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 존재하지 않습니다.");
        }

        if (movableStrategy == null) {
            throw new IllegalArgumentException("이동 전략이 존재하지 않습니다.");
        }
    }

    public void move() {
        if (movableStrategy.isMovable()) {
            this.position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return this.position;
    }
}
