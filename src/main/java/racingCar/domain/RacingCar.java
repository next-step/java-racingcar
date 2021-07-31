package racingCar.domain;

public class RacingCar {

    private String CarName;
    private int drivenDistance;

    private final ForwardPolicy forwardPolicy;

    public String getCarName() {
        return CarName;
    }

    public RacingCar(String carName) {
        StringUtils.isPossibleName(carName);
        this.CarName = carName;
        this.drivenDistance = 0;
        this.forwardPolicy = new ForwardPolicyImpl();
    }

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
