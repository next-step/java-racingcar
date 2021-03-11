package carracing.domain;

import java.util.Random;

/**
 * Car
 * version 0.0.2
 * 
 * history
 *  0.0.1) 클래스 신규생성
 *  0.0.2) Engine 클래스 멤버필드 추가, drive 로직 수정
 */
public class Car {

    private final Engine engine = new Engine(new Random());

    private final int carNumber;
    private int mileage;

    public Car(int carNumber) {
        validate(carNumber);
        this.carNumber = carNumber;
    }

    private void validate(int carNumber) {
        if(carNumber <= 0) {
            throw new IllegalArgumentException("차량번호는 1 이상의 숫자여야 합니다.");
        }
    }

    public int getCarNumber() {
        return carNumber;
    }

    public int getMileage() {
        return mileage;
    }

    public void drive() {
        mileage+=engine.drive();
    }

}
