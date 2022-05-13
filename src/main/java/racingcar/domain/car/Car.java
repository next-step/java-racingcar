package racingcar.domain.car;

import racingcar.domain.policy.MovePolicy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Car {

    private final Participant participant;

    private final int INIT_VALUE = 0;

    private Position position = new Position();

    private RacingRecords records;

    public static Car newInstance(String name) {
        return new Car(new Participant(name));
    }

    public Car(Participant participant) {
        this(participant, new Position());
    }

    public Car(Participant participant, Position position) {
        this.participant = participant;
        this.position = position;
        this.records = new RacingRecords();
    }

    public Position maxPosition(Position maxPosition) {
        if (position.compareTo(maxPosition) > INIT_VALUE) {
            return this.position;
        }

        return maxPosition;
    }


    public Position isCurrentPosition() {
        return this.position;
    }

    public RacingRecord readRacingRecord(int tryNumber) {
        return this.records.readRacingRecord(tryNumber);
    }

    public Position getPosition() {
        return this.position;
    }

    public Participant getParticipant() {
        return this.participant;
    }

    public void move(MovePolicy policy) {
        if (policy.apply()) {
            this.position.plus();
        }
    }

    public void save(RacingRecord racingRecord) {
        List<RacingRecord> recordList = new ArrayList<>(records.getRacingRecords());
        recordList.add(racingRecord);
        this.records = new RacingRecords(recordList);
    }

    public boolean isMaxPosition(Position maxPosition) {
        return this.position.equals(maxPosition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }
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
