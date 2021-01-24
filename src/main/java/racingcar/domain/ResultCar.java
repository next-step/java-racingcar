package racingcar.domain;

public class ResultCar {
    private String carName;
    private int location;

    public ResultCar(String carName, int location) {
        this.carName = carName;
        this.location = location;
    }

    public String getCarName() {
        return carName;
    }

    public int getLocation() {
        return location;
    }
}
