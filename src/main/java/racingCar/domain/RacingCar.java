package racingCar.domain;

public class RacingCar {

    private static final int THRESHOLD = 5;
    private final ForwardPolicy forwardPolicy;

    private String carName;
    private int drivenDistance;

    public RacingCar(String carName) {
        this(carName, 0);
    }

    public RacingCar(String carName, int drivenDistance) {
        this.drivenDistance = drivenDistance;
        this.forwardPolicy = new ForwardPolicyImpl();
        setCarName(carName);
    }

    private void setCarName(String carName) {
        if (!isPossibleName(carName)) {
            throw new IllegalArgumentException();
        }
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    public void goForward(int number) {
        if (forwardPolicy.isMovableNumber(number)) {
            this.drivenDistance++;
        }
    }

    public int getDrivenDistance() {
        return this.drivenDistance;
    }

    public boolean equalsDistance(int distance) {
        return drivenDistance == distance;
    }

    private Boolean isPossibleName(String name) {
        return checkStringLength(name);
    }

    private boolean checkStringLength(String name) {
        return name.length() <= THRESHOLD;
    }
}
