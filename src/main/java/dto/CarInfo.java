package dto;

import model.CarName;
import model.Position;

public class CarInfo {
    private CarName carName;
    private Position position;

    public CarInfo(CarName carName, Position position) {
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
