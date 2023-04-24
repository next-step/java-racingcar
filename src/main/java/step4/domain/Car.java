package step4.domain;

import step4.service.ForwardStrategy;

public class Car {

    private Position position;
    private final Name name;

    public Car(Position position, Name name) {
        this.position = position;
        this.name = name;
    }

    public void forward(ForwardStrategy forwardStrategy) {
        if (forwardStrategy.isMovable()) {
            position.forward();
        }
    }

    public Position toPosition() {
        return position;
    }

    public Name toName() {
        return name;
    }

    public boolean isWinner(Position winner) {
        return this.position.equals(winner);
    }
}
