package racingcar.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CarName {
    private static final Map<String, CarName> CACHE = new HashMap<>();
    private String value;

    private CarName(String value) {
        this.value = value;
    }

    public static CarName valueOf(String value) {
        if (!CACHE.containsKey(value)) {
            CarName carName = new CarName(value);
            CACHE.put(value, carName);
        }

        return CACHE.get(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarName)) return false;
        CarName carName = (CarName) o;
        return value.equals(carName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
