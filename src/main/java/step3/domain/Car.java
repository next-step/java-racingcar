package step3.domain;

public abstract class Car {

    private int carId;
    private String mileAge;

    public Car(int carId) {
        this.carId = carId;
        this.mileAge = "";
    }

    public int getCarId() {
        return carId;
    }

    public String getMileAge() {
        return mileAge;
    }

    public void setMileAge(String mileAge) {
        this.mileAge = mileAge;
    }

    public abstract String accelerate();

    public abstract String brake();

    public abstract String move(int racingCondition, int movementPolicy);

}
