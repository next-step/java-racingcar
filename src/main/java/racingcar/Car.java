package racingcar;

public class Car {
    private int carNumber;
    private int position;
    private static int ZERO = 0;

    public Car() {
        this.position = ZERO;
    }

    public Car(int carNumber) {
        this.carNumber = carNumber;
        this.position = ZERO;
    }

    public void changeCarPosition(int randomNumber) {
        MovingStrategy movingStrategy = new MovingStrategy();
        if (movingStrategy.movable(randomNumber)) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

}
