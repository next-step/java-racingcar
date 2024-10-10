package racing;

import java.util.UUID;

public class RacingCar {

    private String name;
    private RacingCarPosition position;
    private final Operator operator;

    public RacingCar(Operator operator) {
        this.name = UUID.randomUUID().toString();
        this.operator = operator;
        this.position = new RacingCarPosition(this.name);
    }

    public RacingCar(String name, Operator operator) {
        this.name = name;
        this.operator = operator;
        this.position = new RacingCarPosition(this.name);
    }

    public void race() {
        if (operator.isOngoing()) {
            this.position.move();
        }
    }

    public String getName() {
        return this.name;
    }

    public RacingCarPosition getPosition() {
        return this.position;
    }
}
