package racingCar.step4;

import java.util.Objects;

public class RacingCar {

    private static final int MINIMUM_MOVE_THRESHOLD = 4;

    private final String name;

    private int position;

    private RacingCar(String name) {
        this(name, 0);
    }

    private RacingCar(String name, int position){
        if(name.length() > 5){
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 입력 가능합니다");
        }
        this.name = name;
        this.position = position;
    }

    public static RacingCar ofName(String name) {
        return new RacingCar(name);
    }

    public static RacingCar ofNameAndPosition(String name, int position) {
        return new RacingCar(name, position);
    }

    public void move(int moveCondition){
        if(isMoveable(moveCondition)) this.position++;
    }

    public boolean isCurrentPosition(int position) {
        return this.position == position;
    }

    private boolean isMoveable(int moveCondition) {
        return moveCondition >= MINIMUM_MOVE_THRESHOLD;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
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
