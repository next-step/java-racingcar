package step3.domain;

public class Car {

    private static String ACCELATE_SIGN = "-";
    private static String BRAKE_SIGN = "";

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

    public String accelerate() {
        return ACCELATE_SIGN;
    }

    public String brake() {
        return BRAKE_SIGN;
    }

}
