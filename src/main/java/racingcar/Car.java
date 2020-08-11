package racingcar;

public class Car {
    private static final int STATUS_LINE = 0;
    private static final int MIN_RANDOM_NUMBER = 3;

    private int statusLine;
    private String carName;

    public Car(String carName) {
        this.statusLine = STATUS_LINE;
        this.carName = carName;
    }

    public void move(int random) {
        if (MIN_RANDOM_NUMBER < random) {
            statusLine++;
        }
    }

    public int getStatusLine() {
        return statusLine;
    }

    public String getCarName() {
        return carName;
    }

}
