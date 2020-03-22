package racingcar;

public class Car {
    private int carNumber;
    private int position;

    public Car() {
        this.position = 0;
    }

    public Car(int carNumber) {
        this.carNumber = carNumber;
        this.position = 0;
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
