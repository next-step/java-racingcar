package step3.domain;

public class RacingCar {

    private RacingCarRule rule = new RacingCarRule();
    private int distance = 0;
    private CarName carName;

    public RacingCar(String carName) {
        this.carName = new CarName(carName);
    }

    public RacingCar(String name, int distance) {
        this(name);
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public CarName name() {
        return carName;
    }

    public void move(NumberGenerator numberGenerator) {
        int movingCondition = numberGenerator.generate();
        if (rule.canMove(movingCondition)) {
            distance += 1;
        }
    }

    public boolean matchDistance(RacingCar other) {
        return this.distance == other.distance;
    }

    public RacingCar getFaster(RacingCar other) {
        if (this.distance > other.distance) return this;
        return other;
    }

    public String drawDistance() {
        return "-".repeat(distance);
    }
}
