package study.carrace.step3.domain;


import java.util.ArrayList;
import java.util.List;

public class Car {
    private final RandomIntegerGenerator randomIntegerGenerator;
    private final int movableNumber;
    private final List<Boolean> moveStatus;

    public Car(RandomIntegerGenerator randomIntegerGenerator, int movableNumber) {
        this.randomIntegerGenerator = randomIntegerGenerator;
        this.movableNumber = movableNumber;
        this.moveStatus = new ArrayList();
    }

    public void moveOrStop() {
        moveStatus.add(isMovable());
    }

    public List getMoveStatus() {
        return moveStatus;
    }

    private boolean isMovable() {
        return randomIntegerGenerator.generate() >= movableNumber;
    }
}
