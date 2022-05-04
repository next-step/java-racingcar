package racingcar.v2.domain.car;

import java.util.Objects;

public class Car {

    private final Participant participant;


    private Position position = new Position();


    public Car(Participant participant) {
        this(participant, new Position());
    }


    public Car(Participant participant, Position position) {
        this.participant = participant;
        this.position = position;
    }

    public Position maxPosition(Position maxPosition) {
        if (position.compareTo(maxPosition) > 0) {
            return this.position;
        }

        return maxPosition;
    }

    public Position getPosition() {
        return this.position;
    }

    public Participant getParticipant() {
        return this.participant;
    }

    public void move(boolean isGo) {
        if (isGo) {
            this.position.plus();
        }
    }

    public boolean isWinner(Position maxPosition) {
        return this.position.equals(maxPosition);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(participant, car.participant) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participant, position);
    }

    @Override
    public String toString() {
        return "Car{" +
                "participant=" + participant +
                ", position=" + position +
                '}';
    }
}
