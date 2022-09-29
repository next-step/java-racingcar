package racingcar;


public class Car {
    private static final int MOVE_MIN_NUM = 4;
    private final String carName;

    private int position = 0;

    public Car(String carName) {
        this.carName = carName;
    }

    public Car(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public void move(int num) {
        if (num >= MOVE_MIN_NUM) {
            position++;
        }
    }
}
