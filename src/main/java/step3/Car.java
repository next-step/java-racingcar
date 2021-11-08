package step3;

public class Car {

    private final MoveStrategy moveStrategy;
    private final Name name;
    private final Position position;

    private Car(MoveStrategy moveStrategy, Name name, Position position) {
        this.moveStrategy = moveStrategy;
        this.name = name;
        this.position = position;
    }

    public static Car createWithDefaultPosition(MoveStrategy moveStrategy, Name name) {
        Position position = Position.withDefaultPosition();
        return new Car(moveStrategy, name, position);
    }

    public static Car create(MoveStrategy moveStrategy, Name name, Position position) {
        return new Car(moveStrategy, name, position);
    }

    public Position getPosition() {
        return position;
    }

    public Car moveOrStop() {
        Position now = this.position;
        if (moveStrategy.test()) {
            now = this.position.move();
        }
        return create(moveStrategy,name,now);
    }

}
