package racingcar.domain;

import racingcar.service.util.Validation;

import java.util.Objects;

public class Record {

    private final int round;
    private final RacingCars cars;

    public Record(int round, RacingCars cars) {

        Validation.nullValueCheck(round);
        Validation.nullValueCheck(cars);

        this.round = round;
        this.cars = cars;
    }

    public RacingCars getCars() {

        return cars;
    }

    public String getVictoryUsers() {

        return cars.getVictoryUsers();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCars racingCar = (RacingCars) o;
        return Objects.equals(cars, racingCar.getCars());
    }
}
