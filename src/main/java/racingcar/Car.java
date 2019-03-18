package racingcar;

public class Car {

    private String carName;
    private int position;
    private static final int INCREASE_VALUE = 1;
    private static final int CHECK_VALUE = 4;

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

    public void move(int randomValue) {
        if (checkMove(randomValue)) {
            position += INCREASE_VALUE;
        }
    }

    boolean checkMove(int value) {
        return value >= CHECK_VALUE;
    }

    public int isMaxPosition(int maxPosition) {
        if (position >= maxPosition) {
            return position;
        }

        return -1;
    }
}
