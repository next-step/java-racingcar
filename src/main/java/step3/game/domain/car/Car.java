package step3.game.domain.car;

public class Car {

    public static final int START_LINE = 0;

    private final Integer moveSteps;
    public final CarName name;

    public Car(CarName name) {
        this(name, START_LINE);
    }

    public Car(CarName name, Integer moveSteps) {
        this.name = name;
        this.moveSteps = moveSteps;
    }

    public Car move() {
        return new Car(this.name, moveSteps +1);
    }

    public Integer getDistance() {
        return moveSteps;
    }

    public String getCarName() {
        return name.getCarName();
    }

    public Integer getMax(int maxMoveStep) {
        return Math.max(this.moveSteps, maxMoveStep);
    }

    public boolean isSame(int moveSteps) {
        return this.moveSteps == moveSteps;
    }
}
