package racingcar.model;

public class Car {

    private int position;

    public Car() {
        this.position = 1;
    }

    public int getPosition() {
        return this.position;
    }

    public void run(RandomNumber randomNumber) {
        if (randomNumber.isMovable()) {
            this.position += 1;
        }
    }
}
