package racingcar;

public class CarPosition {

    private String name;
    private int position;

    public CarPosition(Car car) {
        this.name = car.getName();
        this.position = car.getPosition();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
