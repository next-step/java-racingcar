package racingCar.domain;

public class RacingCar {

    private String carName;
    private int drivenDistance;

    private final ForwardPolicy forwardPolicy;
    private final CarNamePolicy carNamePolicy;

    public RacingCar(String carName) {
        this.drivenDistance = 0;
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

    public int showDrivenDistance() {
        return this.drivenDistance;
    }

    public boolean equalsDistance(int distance) {
        return drivenDistance == distance;
    }
}
