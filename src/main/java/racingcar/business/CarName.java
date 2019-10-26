package racingcar.business;

import java.util.Arrays;
import java.util.function.Predicate;

public enum CarName {
    AVENTADOR("Lamborghini", 0),
    VEYRON("Bugatti", 1),
    F8_SPIDER("Ferrari", 2),
    BOXSTER("Porsche", 3),
    HURACAN("Lamborghini", 4),
    GTS("Ferrari", 5),
    CAYMAN("Porsche", 6),
    LAFERRARI("Ferrari", 7);

    private String brand;
    private int serialNumber;

    CarName(String brand, int serialNumber) {
        this.brand = brand;
        this.serialNumber = serialNumber;
    }

    public static String get(int serialNumber) {
        return Arrays.stream(CarName.values())
                .filter(equals(serialNumber))
                .map(Enum::name)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static Predicate<? super CarName> equals(int serialNumber) {
        return carName -> carName.serialNumber == serialNumber;
    }
}
