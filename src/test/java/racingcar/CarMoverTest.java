package racingcar;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CarMoverTest {

    @DisplayName("자동차를 이동시키면 자동차 개수만큼의 위치 정보를 담은 목록을 리턴한다")
    @Test
    void move() {
        List<Car> cars = getCars(5);
        CarMover mover = new CarMover(new RandomMoveStrategy());
        mover.move(cars);
    }

    private List<Car> getCars(int count) {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            cars.add(new Car());
        }

        return cars;
    }
}
