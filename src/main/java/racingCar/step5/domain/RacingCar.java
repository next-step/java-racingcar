package racingCar.step5.domain;

import java.util.Objects;

public class RacingCar {
    private static final int MOVE_CONDITION_LIMIT = 4;

    private final String name;
    private int position;

    private RacingCar(final String name) {
        this(name, 0);
    }

    private RacingCar(String name, int position) {
        if(name.length() > 5){
            throw new IllegalArgumentException("자동차 이름을 5자 이하로 입력해주세요.");
        }
        this.name = name;
        this.position = position;
    }

    public static RacingCar ofName(final String name) {
        return new RacingCar(name);
    }

    public static RacingCar ofNameAndPosition(final String name, final int position) {
        return new RacingCar(name, position);
    }

    public int maxPosition(int otherPosition) {
        if(position < otherPosition){
            return otherPosition;
        }
        return position;
    }

    public boolean isSamePosition(int otherPosition) {
        return position == otherPosition;
    }

    public void move(int moveCondition) {
        if(isMoveable(moveCondition)){
            position++;
        }
    }

    private boolean isMoveable(int moveCondition) {
        return moveCondition >= MOVE_CONDITION_LIMIT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return position == racingCar.position && Objects.equals(name, racingCar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
