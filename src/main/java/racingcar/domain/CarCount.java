package racingcar.domain;

public class CarCount {
    public final int CAR_COUNT;

    public CarCount(int carCount) throws Exception {
        CAR_COUNT = isValid(carCount);
    }

    private int isValid(int carCount) throws Exception {
        if(carCount >= 0)   return carCount;
        throw new Exception("자동차 수는 0이상의 수만 가능합니다.");
    }

}
