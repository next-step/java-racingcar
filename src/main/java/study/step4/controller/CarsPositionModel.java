package study.step4.controller;

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
}
