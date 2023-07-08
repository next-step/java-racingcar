package racingcar;

import java.util.Objects;

public class CarName {

    public static final int NAME_THRESHOLD = 5;
    private final String carName;

    public CarName(String carName) {
        if (carName.length() > NAME_THRESHOLD) {
            throw new IllegalArgumentException("이름이 " + NAME_THRESHOLD + " 글자 초과입니다.");
        }
        this.carName = carName;
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
        return Objects.hash(carName);
    }

    @Override
    public String toString() {
        return "CarName{" +
                "carName='" + carName + '\'' +
                '}';
    }

    public String getCarName() {
        return carName;
    }
}
