package step5;

import java.util.Objects;

public class CarName {
    private final String carName;

    public CarName(String carName) {
        validateCarName(carName);
        this.carName = carName;
    }

    private void validateCarName(String carName) {
        if (carName.isBlank()) {
            throw new RuntimeException("자동차의 이름은 공백일 수 없다.");
        }
        if (carName.length() > 5) {
            throw new RuntimeException("자동차의 이름은 5자를 초과할 수 없다.");
        }
    }

    String getCarName() {
        return this.carName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName1 = (CarName) o;
        return Objects.equals(carName, carName1.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(carName);
    }
}
