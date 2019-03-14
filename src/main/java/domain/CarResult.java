package domain;

public class CarResult {
    private String name;
    private Integer mileage;

    public CarResult(Car car) {
        this.name = car.getName();
        this.mileage = car.getMileage();
    }

    public String getName() {
        return name;
    }

    public Integer getMileage() {
        return mileage;
    }
}
