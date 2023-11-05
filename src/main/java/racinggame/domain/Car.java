package racinggame.domain;

public class Car {

    private static final int MOVE_CAR_CONDITION = 4;

    private int position;
    private Name carName;
    private GenerateNumber generateNumber;

    public Car(Name carName, GenerateNumber generateNumber) {
        this.carName = carName;
        this.generateNumber = generateNumber;
    }

    public void moving() {
        if (generateNumber.number() >= MOVE_CAR_CONDITION) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }

}
