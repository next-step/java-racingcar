package carracing.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CarName {

    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final String INVALID_NAME_LENGTH_EXCEPTION_MESSAGE_FORMAT = "자동차 이름이 유효하지 않습니다. name: %s";

    private static final Map<String, CarName> cache = new HashMap<>();

    private final String name;

    private CarName(String name) {
        this.name = name;
        cache.put(name, this);
    }

    public static CarName of(String name) {
        validateNameLength(name);
        return cache.containsKey(name) ? cache.get(name) : new CarName(name);
    }

    private static void validateNameLength(String name) {
        if (name == null || name.isEmpty() || name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format(INVALID_NAME_LENGTH_EXCEPTION_MESSAGE_FORMAT, name));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarName)) return false;
        CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
