package racingcar.domain;

public class RacingCar {
    final static int CAR_MOVEMENT_STANDARD_POINT = 4;   // random 값이 4이상인 경우 전진
    final static int DEFAULT_MOVEMENT_DISTANCE = 1;     // 자동차 이동 시 1만큼 전진
    private int position = 1;       // 차가 이동한 위치

    public RacingCar() {

    }

    public void moveForward() {
        RandomNumber randomNumber = new RandomNumber();
        if(randomNumber.calculateRandomNumber() >= CAR_MOVEMENT_STANDARD_POINT) {
            this.position += DEFAULT_MOVEMENT_DISTANCE;
        }
    }

    public int getPosition() {
        return this.position;
    }

}
