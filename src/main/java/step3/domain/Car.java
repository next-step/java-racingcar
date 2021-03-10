package step3.domain;

import step3.move.ConditionMoveStrategy;
import step3.move.MoveStrategy;

import java.util.Objects;

import static step3.util.Constants.START_IDX;

/**
 * 자동차의 상태와 행위를 관리하는 클래스
 */
public class Car {

    // 메시지를 처리하기 위해 자율적으로 선택
    private final MoveStrategy moveStrategy;

    private int position;
    private final String name;

    // 생성하는 쪽에서 무조건 이동하는 전략을 넣지 않고도 기본 값으로 사용할 수 있는 전략을 설정
    public Car(final String name) {
        this(name, new ConditionMoveStrategy());
    }

    // 인터페이스를 파라미터로 받아 외부에서 움직임의 기준을 변경할 수 있도록 수정
    public Car(final String name, final MoveStrategy moveStrategy) {
        this(name, START_IDX, moveStrategy);
    }

    public Car(final String name, final int position, final MoveStrategy moveStrategy) {
        this.name = name;
        this.position = position;
        this.moveStrategy = moveStrategy;
    }

    public Car move() {
        if (moveStrategy.isMovable()) {
            position++;
        }
        // 이동 하면 새로 생성해야 하는게 맞을까?
        return new Car(name, position, moveStrategy);
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
        if (!(o instanceof Car)) return false;
        final Car car = (Car) o;
        return getPosition() == car.getPosition() && name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPosition(), name);
    }
}
