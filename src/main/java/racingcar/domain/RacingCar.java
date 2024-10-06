package racingcar.domain;

import racingcar.service.dto.RacingCarDto;

import java.util.Objects;

public class RacingCar {

    private int position;
    private final String name;
    public static final int DEFAULT_POSITION = 1;
    public static final int MAX_NAME_LENGTH = 5;

    public RacingCar(String name) {
        this(name, DEFAULT_POSITION);
    }

    public RacingCar(String name, int position) {
        this.position = position;
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalStateException("자동차의 이름은 5자리를 초과할 수 없습니다.");
        }
        this.name = name;
    }

    public int getMaxPosition(int maxPosition) {
        return Math.max(position, maxPosition);
    }

    public boolean isSamePosition(int position) {
        return position == this.position;
    }

    public void move(boolean movable) {
        if (movable) {
            move();
        }
    }

    public void move() {
        this.position++;
    }

    public String getName() {
        return this.name;
    }

    public RacingCarDto toDto() {
        return new RacingCarDto(this.name, this.position);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        RacingCar racingCar = (RacingCar) object;
        return position == racingCar.position && Objects.equals(getName(), racingCar.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, getName());
    }
}

