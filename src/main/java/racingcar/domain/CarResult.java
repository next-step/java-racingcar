package racingcar.domain;

public class CarResult {

    private String name;
    private int position;

    public CarResult(Car car) {
        this.name = car.nameValue();
        this.position = car.positionValue();
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

}
