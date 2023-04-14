package racingcar.domain;

public interface CarInterface {
    public final int CAR_MOVEMENT_STANDARD_POINT = 4;   // random 값이 4이상인 경우 전진
    public final int MOVEMENT_DISTANCE = 1;     // 자동차 이동 시 1만큼 전진
    public final int POSITION = 0;

    public void move();

    public int position();
}
