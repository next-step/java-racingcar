package carracing.domain;

/**
 * CarService
 * version 0.0.1
 *
 * history
 * 0.0.1) 클래스 신규생성
 */
public class CarService {

    public Car registerCar(int carNumber) {
        validate(carNumber);
        return new Car(carNumber);
    }

    private void validate(int carNumber) {
        if(carNumber <= 0) {
            throw new IllegalArgumentException("차량번호는 1 이상의 숫자여야 합니다.");
        }
    }
}
