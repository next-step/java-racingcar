package core;

import utils.AnnouncementPrinter;

import java.util.Objects;

public class CarName {
    public static final int MAX_CAR_NAME_LENGTH = 5;
    private String carName;

    private CarName(String carName) {
        this.carName = carName;
    }

    public static CarName create(String inputCarName) {
        if (inputCarName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(AnnouncementPrinter.CAR_NAME_INVALID_ANNOUNCEMENT);
        }
        return new CarName(inputCarName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName1 = (CarName) o;
        return carName.equals(carName1.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }

    @Override
    public String toString() {
        return carName;
    }
}
