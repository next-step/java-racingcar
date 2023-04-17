package step4.domain.entity;

public class Car {

    private Position position;
    private final Name name;

    public Car(Position position, Name name) {
        this.position = position;
        this.name = name;
    }

    public void forward(int random) {
        position.forward(random);
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
