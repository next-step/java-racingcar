package racingcar;

public class CarPosition {

    private int position;

    public CarPosition(Car car) {
        this.position = car.getPosition();
    }

    public int getPosition() {
        return position;
    }
}
