package racing.domain;

public class CarResult {

    private final CarName carName;
    private final Position position;

    public CarResult(CarName carName, Position position) {
        this.carName = carName;
        this.position = position;
    }

    public CarName getCarName() {
        return carName;
    }

    public Position getPosition() {
        return position;
    }
}
