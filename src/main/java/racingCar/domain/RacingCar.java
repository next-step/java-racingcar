package racingCar.domain;

public class RacingCar {

    private int drivenDistance;

    private final ForwardPolicy forwardPolicy;

    public RacingCar() {
        this.drivenDistance = 0;
        this.forwardPolicy = new ForwardPolicyImpl();
    }

    public void goForward(int number) {
        if (forwardPolicy.isMovableNumber(number)) {
            this.drivenDistance++;
        }
    }

    public int showDrivenDistance() {
        return this.drivenDistance;
    }
}
