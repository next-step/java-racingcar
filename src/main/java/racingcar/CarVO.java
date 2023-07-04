package racingcar;

import java.util.Objects;

public class CarVO {

    private final String name;
    private final int position;

    public CarVO(Car car) {
        this.name = car.getName();
        this.position = car.getPosition();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarVO carVO = (CarVO) o;
        return position == carVO.position && Objects.equals(name, carVO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
