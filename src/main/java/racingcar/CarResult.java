package racingcar;

public class CarResult {

    private String name;
    private int position;

    public CarResult(Car car) {
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
