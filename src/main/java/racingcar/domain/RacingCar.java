package racingcar.domain;

import java.util.Objects;

public class RacingCar {

    private final int MOVE_LENGTH = 1;
    private final int MAX_LENGTH_NAME = 5;

    private final String name;
    private final Position position;

    public RacingCar(String name) {
        this(name, 0);
    }

    public RacingCar(String name, int position) {
        validateName(name);
        this.name = name;
        this.position = new Position(position);
    }

    public void move(MoveCondition moveCondition) {
        if (moveCondition.canMove()) {
            position.increase(MOVE_LENGTH);
        }
    }

    public int getPosition() {
        return position.getValue();
    }

    public String getName() {
        return name;
    }

    public boolean isEqualsPosition(int position) {
        return this.position.getValue() == position;
    }

    private void validateName(String name) {
        validateNameLongerThenFive(name);
        validateNameIsEmpty(name);
    }

    private void validateNameLongerThenFive(String name) {
        if (name.length() > MAX_LENGTH_NAME) {
            throw new RuntimeException("자동차의 이름은 5자를 초과할 수 없습니다.");
        }
    }

    private void validateNameIsEmpty(String name) {
        if (name == null || name.isEmpty()) {
            throw new RuntimeException("자동차의 이름은 빈 문자열로 설정할 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RacingCar)) {
            return false;
        }

        RacingCar racingCar = (RacingCar) o;

        if (!Objects.equals(name, racingCar.name)) {
            return false;
        }
        return Objects.equals(position, racingCar.position);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }
}
