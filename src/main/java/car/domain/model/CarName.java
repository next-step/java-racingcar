package car.domain.model;

import java.util.Objects;

public final class CarName {

    private final static int TEXT_LENGTH_LIMIT = 5;
    private final String myCarName;

    public CarName(final String eachCarName) {
        validateNameLength(eachCarName);
        this.myCarName = eachCarName;
    }

    private void validateNameLength(final String carName) {
        if (carName.length() > TEXT_LENGTH_LIMIT) {
            throw new IllegalArgumentException(TEXT_LENGTH_LIMIT + "글자 아래로 작성해 주세요.");
        }
    }

    public String getMyCarName() {
        return myCarName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarName carName = (CarName) o;
        return Objects.equals(myCarName, carName.myCarName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(myCarName);
    }
}
