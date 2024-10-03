package racinggame.racingcar;

public class RacingCar {
    private final CarName name;
    private final CarPosition position;
    private final MoveStrategy moveStrategy;

    private RacingCar(CarPosition position, MoveStrategy moveStrategy, CarName name) {
        this.position = position;
        this.moveStrategy = moveStrategy;
        this.name = name;
    }

    public static RacingCar create(MoveStrategy moveStrategy, String name) {
        return new RacingCar(new CarPosition(), moveStrategy, new CarName(name));
    }

    public void move() {
        if (moveStrategy.shouldMove()) {
            position.moveForward();
        }
    }

    int getCurrentPosition() {
        return position.getCurrentValue();
    }

    String getCarName() {
        return name.getValue();
    }
}
