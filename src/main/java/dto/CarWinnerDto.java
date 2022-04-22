package dto;

import model.CarName;

public class CarWinnerDto {
    private CarName carName;

    public CarWinnerDto(CarName carName) {
        this.carName = carName;
    }

    public CarName getCarName() {
        return carName;
    }

}
