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

    public boolean accelerate() {
        return true;
    }

    public boolean brake() {
        return false;
    }

    public abstract boolean move(int racingCondition, int movementPolicy);

}
