package racing;

public class Car {

    private String carName;

    private Integer distance;

    public Car() {
        this.distance = 0;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public void plusDistance() {
        this.distance = this.distance + 1;
    }
}
