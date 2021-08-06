package racingCar.domain;

public class RacingCar {

    private final ForwardPolicy forwardPolicy;
    private final CarNamePolicy carNamePolicy;

    private String carName;
    private int drivenDistance;

    public RacingCar(String carName) {
        this(carName, 0);
    }

    public RacingCar(String carName, int drivenDistance) {
        this.drivenDistance = drivenDistance;
        this.forwardPolicy = new ForwardPolicyImpl();
        this.carNamePolicy = new CarNamePolicyImpl();
        setCarName(carName);
    }

    private void setCarName(String carName) {
        if (!carNamePolicy.isPossibleName(carName)) {
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

    public int getDrivenDistnace() {
        return this.drivenDistance;
    }

    public boolean equalsDistance(int distance) {
        return drivenDistance == distance;
    }
}
