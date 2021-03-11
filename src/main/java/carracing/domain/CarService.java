package carracing.domain;

/**
 * CarService
 * version 0.0.1
 *
 * history
 * 0.0.1) 클래스 신규생성
 */
public class CarService {

    public Cars registerCars(int racingCarCount) {
        return new Cars(racingCarCount);
    }
}
