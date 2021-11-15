package domain;

public class CarRace {
    private final CarName carName;
    private final CarPosition carPosition;

    public CarRace(CarName carName, CarPosition carPositing) {
        this.carName = carName;
        this.carPosition = carPositing;
    }

    public CarRace positionPlus(int plusNumber) {
        carPosition.positionPlus(plusNumber);
        return new CarRace(carName, new CarPosition(carPosition.value()));
    }

    public String name() {
        return carName.value();
    }

    public int position() {
        return carPosition.value();
    }
}
