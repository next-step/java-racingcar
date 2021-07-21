package racingcar;

public class Car {
    private final static int GO_VALUE = 4;
    private int moveSpace;

    public Car(int moveSpace) {
        this.moveSpace = moveSpace;
    }

    public int getMoveSpace() {
        return moveSpace;
    }

    public int advanceOrStop(int randomValue) {
        if(randomValue >= GO_VALUE) {
            return 1;
        }
        return 0;
    }

    public int move(int index) {
        moveSpace += index;
        return moveSpace;
    }

}
