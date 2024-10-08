package racing.domain.car;

import java.util.Objects;

public class Car {
    private static final int MIN_BOUND = 0;
    private static final int MAX_BOUND = 9;
    private static final int STANDARD = 4;

    private Position position;
    private final String name;

    public Car(final String name, final int position) {
        this(name, new Position(position));
    }

    public Car(final String name, final Position position) {
        this.name = name;
        this.position = new Position(position.getValue());
    }

    //깊은 복사 RacingGame 뷰 분리를 위해서
    public Car(Car car){
        this.name = car.getName();
        this.position = new Position(car.getPosition());
    }

    public boolean isGo(int randomNumber) {
        if (randomNumber < MIN_BOUND || randomNumber > MAX_BOUND) {
            throw new IllegalArgumentException("랜덤 값이 범위를 초과하였습니다.");
        }
        if (randomNumber >= STANDARD) {
            //this.position = position.increase();
            this.position = new Position(position.increase().getValue());
            return true;
        }
        return false;
    }

    public int getPosition() {
        return position.getValue();
    }

    public int maxPosition(int maxPosition) {
        return this.position.maxPosition(maxPosition);
    }

    public boolean isSame(int maxPosition){
        return this.position.isSame(maxPosition);
    }

    public String getName() {
        return name;
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
