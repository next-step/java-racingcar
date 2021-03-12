package carracing.domain;

/**
 * CarService
 * version 0.0.1
 *
 * history
 * 0.0.1) 클래스 신규생성
 * 0.0.2) Car 객체 단일등록로직 제거, Cars 객체 리턴로직 추가
 */
public class CarService {

    public Cars registerCars(int racingCarCount) {
        return new Cars(racingCarCount);
    }
}
