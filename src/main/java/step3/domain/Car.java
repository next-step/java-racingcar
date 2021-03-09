package step3.domain;

import step3.move.ConditionMoveStrategy;
import step3.move.MoveStrategy;

/**
 * 자동차의 상태와 행위를 관리하는 클래스
 */
public class Car {

    // 메시지를 처리하기 위해 자율적으로 선택
    private final MoveStrategy moveStrategy;

    private int position;

    // 생성하는 쪽에서 무조건 이동하는 전략을 넣지 않고도 기본 값으로 사용할 수 있는 전략을 설정
    public Car(final int position) {
        this(position, new ConditionMoveStrategy());
    }

    // 인터페이스를 파라미터로 받아 외부에서 움직임의 기준을 변경할 수 있도록 수정
    public Car(final int position, final MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
        this.position = position;
    }

    public Car move() {
        if (moveStrategy.isMovable()) {
            position++;
        }
        // 이동 하면 새로 생성해야 하는게 맞을까?
        return new Car(position, moveStrategy);
    }

    public int getPosition() {
        return position;
    }
}
