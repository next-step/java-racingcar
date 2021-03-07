package step3.domain;

/**
 * 자동차의 상태와 행위를 관리하는 클래스
 */
public class Car {

    public static final int MOVE_CONDITION = 4;
    private int position;

    private Car() {
        this.position = 1;
    }

    // 자동차 생성
    public static Car of() {
        return new Car();
    }

    public int getPosition() {
        return position;
    }

    // 자동차의 전진 기능
    public void move(int value) {
        if(isMove(value)) {
            position++;
        }
    }

    // 자동차가 전진하기 위한 조건 처리
    private boolean isMove(int value) {
        return value >= MOVE_CONDITION;
    }
}
