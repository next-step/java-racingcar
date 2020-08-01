package step3.dto;

public class CarWentResult {

    private final Integer distance;

    private final Integer carNumber;

    public CarWentResult(Integer distance, Integer carNumber) {
        this.distance = distance;
        this.carNumber = carNumber;
    }

    public Integer getDistance() {
        return distance;
    }

    public Integer getCarNumber() {
        return carNumber;
    }
}
