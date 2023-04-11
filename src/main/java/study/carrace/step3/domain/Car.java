package study.carrace.step3.domain;


import java.util.ArrayList;
import java.util.List;

public class Car {
    private final MoveStrategy moveStrategy;
    private final List<Boolean> moveStatus;

    public Car(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
        this.moveStatus = new ArrayList<>();
    }

    public void moveOrStop() {
        moveStatus.add(moveStrategy.moveOrStop());
    }

    public List<Boolean> getMoveStatus() {
        return moveStatus;
    }
}
