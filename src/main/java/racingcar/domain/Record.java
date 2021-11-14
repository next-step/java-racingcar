package racingcar.domain;

import racingcar.service.util.Validation;

import java.util.Objects;

public class Record {

    private final int tryCount;
    private final RacingCars cars;

    public Record(int tryCount, RacingCars cars) {

        Validation.nullValueCheck(tryCount);
        Validation.nullValueCheck(cars);

        this.tryCount = tryCount;
        this.cars = cars;
    }

    public RacingCars getCars() {

        return cars;
    }

    public String getVitoryUsers() {

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
