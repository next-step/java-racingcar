package racing;

import java.util.Objects;

import static racing.StringUtils.repeatString;

public class Car {
    private Long position;
    private String name;

    private static final String DISTANCE_GRAPH = "-";
    private static final int CAR_NAME_LENGTH = 5;

    public Car(String name) {
        this.position = 0L;
        validateCarName(name);
        this.name = name;
    }

    public void forward(MovingStrategy strategy) {
        if (strategy.isMovable()) this.position++;
    }

    public boolean isWinner(Long maxPosition) {
        return this.position >= maxPosition;
    }

    public Long getMaxPosition(Long maxPosition) {
        return (this.isWinner(maxPosition)) ? this.position : maxPosition;
    }

    public void printDistance() {
        System.out.print(repeatString(DISTANCE_GRAPH, this.position));
    }

    public void printName() {
        System.out.print(this.name);
    }

    private void validateCarName(String carName) {
        if (StringValidator.isBlank(carName) || !StringValidator.isLessThanEqualLen(carName, CAR_NAME_LENGTH)) {
            throw new RuntimeException("이름이 유효하지 않습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(position, car.position) && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }
}
