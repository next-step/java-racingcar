package racinggame.domain;

public class NeverMoveCar extends Car {

    public NeverMoveCar(CarName name) {
        super(name);
    }

    @Override
    public void run(MoveCondition condition) {
        super.run(new NeverMoveCondition());
    }
}
