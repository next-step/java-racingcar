package racingcar.domain;

public class ResultCar {
    private String car;
    private int location;

    public ResultCar(String car, int location) {
        this.car = car;
        this.location = location;
    }

    public String getCar() {
        return car;
    }

    public int getLocation() {
        return location;
    }
}
