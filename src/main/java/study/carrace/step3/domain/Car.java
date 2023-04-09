package study.carrace.step3.domain;


import java.util.ArrayList;
import java.util.List;

public class Car {
    private final RandomIntegerGenerator randomIntegerGenerator;
    private final int movableThreshold;
    private final List<Boolean> moveStatus;

    public Car(RandomIntegerGenerator randomIntegerGenerator, int movableThreshold) {
        this.randomIntegerGenerator = randomIntegerGenerator;
        this.movableThreshold = movableThreshold;
        this.moveStatus = new ArrayList<>();
    }

    public void moveOrStop() {
        moveStatus.add(isMovable());
    }

    public List<Boolean> getMoveStatus() {
        return moveStatus;
    }

    private boolean isMovable() {
        return randomIntegerGenerator.generate() >= movableThreshold;
    }
}
