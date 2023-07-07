package racingcar.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class CarVO {

    private final String name;
    private final int position;

    private CarVO(final Car car) {
        this.name = car.getName();
        this.position = car.getPosition();
    }

    public static List<CarVO> toList(final List<Car> cars) {
        return cars.stream()
                .map(CarVO::new)
                .collect(Collectors.toUnmodifiableList());
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
