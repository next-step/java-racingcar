package racingcar.service;

public class RacingCar {
    final static int CAR_MOVEMENT_STANDARD_POINT = 4;   // random 값이 4이상인 경우 전진
    final static int DEFAULT_MOVEMENT_DISTANCE = 1;     // 자동차 이동 시 1만큼 전진
    private String carNumber;   // 차 넘버
    private int position;       // 차가 이동한 위치

    public RacingCar(String carNumber) {
        this.carNumber = carNumber;
    }

    // CAR_MOVEMENT_PERCENTAGE 확률로 DEFAULT_MOVEMENT_DISTANCE 만큼 자동차 이동
    public void moveForward(int randomNumber) {
        if(randomNumber >= CAR_MOVEMENT_STANDARD_POINT) {
            this.position += DEFAULT_MOVEMENT_DISTANCE;
        }
    }

    // 자동차 number 값 가져오기
    public String getNumber() {
        return this.carNumber;
    }

    // 자동차 위치 값 가져오기
    public int getPosition() {
        return this.position;
    }

}
