package step4.domain.car;

import step4.domain.car.name.Name;
import step4.domain.car.position.Position;
import step4.startegy.Move;

public final class Car {

    private final Name name;
    private Position position;

    public Car(String name) {
        this(new Name(name));
    }

    public Car(Name name) {
        this.name = name;
        this.position = new Position();
    }

    public final void move(Move move) {
        if (move.isMovable()) {
            position.increase();
        }
    }

    public final Name name() {
        return name;
    }

    public final Position position() {
        return position;
    }

    public final boolean isWinner(int winnerPosition) {
        return (position.position() == winnerPosition);
    }
}
