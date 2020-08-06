package racingcar.domain;

/**
 * 자동차에 대한 정보를 담당
 * 자동차의 전진 여부를 판단하고 전진시키는 역할이 필요
 * 자동차는 랜덤 값이 4 이상일 때 1칸 전진할 수 있다.
 */
public class Car {
    private static final int START_POSITION = 0;
    private static final int MOVEABLE_REFERENCE_VALUE = 4;

    private int position;

    public int getPosition() {
        return position;
    }

    public Car() {
        this.position = START_POSITION;
    }

    public void moveCount(int randomValue) {
        if(randomValue >= MOVEABLE_REFERENCE_VALUE) {
            position++;
        }
    }
}
