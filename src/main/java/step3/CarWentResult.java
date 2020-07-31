package step3;

public class CarWentResult {

    Integer distance;

    Integer carNumber;

    public CarWentResult(Car car) {
        this.distance = car.getDistance();
        this.carNumber = car.getCarNumber();
    }

    public Integer getDistance() {
        return distance;
    }

    public Integer getCarNumber() {
        return carNumber;
    }
}
