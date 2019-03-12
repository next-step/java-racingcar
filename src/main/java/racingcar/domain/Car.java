package racingcar.domain;

public class Car {

    private static final int ADVANCE_CONDITION = 3;
    private int position;

    public Car(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        int newPosition = RandomCreator.createNewPosition();
        if(ADVANCE_CONDITION < newPosition) {
            this.position += newPosition;
        }
    }

}
