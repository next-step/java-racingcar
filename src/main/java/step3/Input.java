package step3;

public class Input {
    private static int carsQuantity;
    private static int times;

    public static int getCarsQuantity() {
        return carsQuantity;
    }

    public static int getTimes() {
        return times;
    }

    void inputCarsQuantity(int carsQuantity) {
        this.carsQuantity = carsQuantity;
    }

    void inputTimes(int times) {
        this.times = times;
    }
}
