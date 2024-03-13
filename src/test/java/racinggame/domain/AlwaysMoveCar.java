package racinggame.domain;

public class AlwaysMoveCar extends Car{

    public AlwaysMoveCar(CarName name) {
        super(name);
    }

    @Override
    public void run(MoveCondition condition) {
        super.run(new AlwaysMoveCondition());
    }
}
