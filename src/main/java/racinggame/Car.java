package racinggame;

public class Car {

    private static final int MOVE_CAR_CONDITION = 4;

    private int position;
    private GenerateNumber generateNumber;

    public Car(GenerateNumber generateNumber) {
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
