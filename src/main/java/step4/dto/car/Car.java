package step4.dto.car;

import step4.common.MyNumber;
import step4.dto.RunStrategy;
import step4.dto.count.Count;
import step4.dto.count.Position;

public class Car {
    private final Position position;
    private RunStrategy runStrategy;
    private final String name;

    public Car(RunStrategy runStrategy, String name) {
        position = new Position(MyNumber.ZERO.getValue());

        this.runStrategy = runStrategy;
        this.name = name;
    }

    public void run(Count runCount) {
        if(runStrategy.runnable(runCount)) {
            position.plusPosition();
        }
    }

    public Position getPosition() {
        return position;
    }

    public boolean isMaxPosition(Position other) {
        return this.position.isMaxPosition(other);
    }

    public Position maxPosition() {
        return new Position(this.position);
    }

    public String getName() {
        return name;
    }
}
