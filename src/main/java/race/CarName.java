package race;

import java.util.Objects;

public class CarName {
    private final String carName;
    private static final int MAX_LENGTH = 5;

    public CarName(String carName) {
        if (carName.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("CarName의 최대 길이를 초과했습니다.");
        }

        this.carName = carName;
    }

    public String get() {
        return carName;
    }

    @Override
    public boolean equals(Object o) {
        if (carName.equals(o)) return true;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return Objects.equals(this.carName, carName.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }
}
