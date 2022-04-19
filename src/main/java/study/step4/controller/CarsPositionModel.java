package study.step4.controller;

import study.step4.domain.Car;

public class CarsPositionModel {
    private String carName;
    private int position;

    public CarsPositionModel(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public static CarsPositionModel from(Car car) {
        return new CarsPositionModel(car.getCarName().getCarName(), car.getCarPosition().getPosition());
    }

    public String toMarker() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.getPosition(); i++) {
            sb.append("-");
        }
        return sb.toString();
    }

}
