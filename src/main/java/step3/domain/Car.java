package step3.domain;

public class Car {

    private static final int HIGH_POWER_BOUNDARY = 4;
    private static final int ENGINE_POWER_LIMIT = 9;

    private final String carNumber;
    private int runDistance;
    private int enginePower;


    public Car(String carNumber) {
        this.carNumber = carNumber;
    }

    public void run() {
        prepareEngine();
        if (enginePower >= HIGH_POWER_BOUNDARY) {
            runDistance++;
        }
    }

    public String getCarNumber() {
        return carNumber;
    }

    public int getRunDistance() {
        return runDistance;
    }

    private void prepareEngine() {
        enginePower = (int) (Math.random() * ENGINE_POWER_LIMIT);
    }
}
