package step5.car;

import step5.message.ExceptionMessage;

public class RacingCar implements CarStrategy {

    private final static int FORWARD_DISTANCE = 1; //전진하는 거리
    private final static int miniMumCarNameLength = 5; //자동차 이름 최대 길이

    private String carName; //자동차이름
    private int distance = 0; //현재 전진한 거리

    public RacingCar(String carName) {
        changeCarName(carName);
    }

    public RacingCar(String carName, int distance) {
        changeCarName(carName);
        this.distance = distance;
    }

    //차를 전진한다.
    @Override
    public void forward() {
        this.distance += FORWARD_DISTANCE;
    }

    @Override
    public int getDistance() {
        return distance;
    }

    @Override
    public String getCarName() {
        return this.carName;
    }

    //객체를 복사한다.
    @Override
    public CarStrategy copy() {
        return new RacingCar(this.carName, this.distance);
    }

    //자동차 이름 변경
    private void changeCarName(String carName) {
        checkCarNameLength(carName);
        this.carName = carName;
    }

    //레이싱에 참가하는 자동차이름이 5자를 초과하는지 체크
    private void checkCarNameLength(String carName) {
        if (carName.length() > miniMumCarNameLength)
            throw new IllegalArgumentException(ExceptionMessage.MINIMUN_CAR_NAME_EXCEPTION.message());
    }

}