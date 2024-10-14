package racing.domain;

public class RacingCar {

    private final String name;
    private final RacingCarPosition position;
    private final Operator operator;

    public RacingCar(Operator operator) {
        this.name = null;
        this.operator = operator;
        this.position = new RacingCarPosition();
    }

    public RacingCar(String name, Operator operator) {
        this.name = name;
        this.operator = operator;
        this.position = new RacingCarPosition();
    }

    public void race() {
        if (operator.isOngoing()) {
            this.position.move();
        }
    }

    public String getName() {
        return this.name;
    }

    public Integer getCurrentPosition() {
        return this.position.getPosition();
    }
}
