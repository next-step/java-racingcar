package racingcar.service.domain;

import racingcar.service.model.Cars;
import racingcar.service.value.Round;
import racingcar.utils.Preconditions;

import java.util.Objects;

public class Record {
    private final Round round;
    private final Cars cars;

    public Record(Round round, Cars cars) {
        Preconditions.checkNotNull(round, "round는 필수값입니다.");
        Preconditions.checkNotNull(cars, "cars는 필수값입니다.");

        this.round = round;
        this.cars = cars;
    }

    public Round getCurrentRound() {
        return round;
    }

    public String getFinalWinnerName() {
        return cars.getFinalWinnerName();
    }

    public Cars getCars() {
        return cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return round.equals(record.round) && cars.equals(record.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(round, cars);
    }
}
