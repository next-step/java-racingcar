package racingcar;

public class Car {

    private int distance;

    public Car() {
        this.distance = 0;
    }

    public int move(int value) {
        return (value < 4) ? distance : ++distance;
    }

}
