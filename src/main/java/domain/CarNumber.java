package domain;

public class CarNumber {
    private final int carNumber;
    public CarNumber(int carNumber) {
        if (carNumber < 0)
            throw new RuntimeException("CarNumber can not be negative");
        this.carNumber = carNumber;
    }

    public int getCarNumber() {
        return carNumber;
    }
}
