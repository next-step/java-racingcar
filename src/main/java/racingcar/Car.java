package racingcar;

public class Car implements Cloneable{

    private int position;

    public Car() {
        this.position = 0;
    }

    public Car (Car car) {
        this.position = car.getPosition();
    }

    public int getPosition() {
        return position;
    }

    public void move(int randomNum) {
        if (randomNum >= 4) {
            position++;
        }
    }
}
