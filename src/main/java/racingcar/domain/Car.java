package racingcar.domain;

import racingcar.domain.strategy.MoveStrategy;

public class Car implements Comparable<Car>{
    private int position;
    private Participant participant;

    public Car() {
        this.position = 0;
    }

    private Car(Participant participant) {
        this.position = 0;
        this.participant = participant;
    }

    public static Car from(Participant participant) {
        return new Car(participant);
    }

    public int getPosition() {
        return position;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void moveForward(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            this.position++;
        }
    }

    public boolean isWinner(int winnerPosition) {
        return this.position >= winnerPosition;
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(this.position, o.position);
    }
}
