package step3.domain;

import java.util.Collections;
import java.util.List;

/**
 * 레이싱 한 번의 라운드를 관리하는 클래스
 */
public class RacingRound {

    private final List<Car> cars;

    public RacingRound(final List<Car> movedCars) {
        cars = movedCars;
    }

    // 읽기 전용으로 조회
    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
