package racingcar;

public class Car {

    private Position position;

    public Car() {
        this.position = new Position(0);
    }

    public Car (Car car) {
        this.position = new Position(car.position);
    }

    public int getPosition() {
        return position;
    }

    public void move(int randomNum) {
        if (randomNum >= 4) {
            position = position.increase();
        }
    }

}
