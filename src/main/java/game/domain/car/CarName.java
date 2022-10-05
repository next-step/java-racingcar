package game.domain.car;

import java.util.Objects;

public class CarName {

    private static int NAME_LIMIT_LENGTH = 5;
    private static String CARNAME_EXCEPTION = "CarName 길이는 " + NAME_LIMIT_LENGTH + "를 초과할 수 없습니다.";
    private String name;

    public CarName(String name) {
        if (name.length() > NAME_LIMIT_LENGTH) {
            throw new IllegalArgumentException(CARNAME_EXCEPTION);
        }
        this.name = name;
    }

    public CarName(CarName carName) {
        this(carName.getCarName());
    }

    public String getCarName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
