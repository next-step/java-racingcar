package carRacing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    Cars cars;

    @BeforeEach
    void create() {
        int carCount = 3;
        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }
        cars = new Cars(carList);
    }

    @Test
    @DisplayName("자동차 목록이 선언된 자동차 수만큼 생성되었는지 확인")
    void 자동차목록_객체_확인() {
        assertThat(cars).isNotNull();
    }

    @Test
    @DisplayName("자동차 목록을 생성 후 목록 거리 반환 확인")
    void 자동차목록_거리_반환_확인() {
        assertThat(cars.getDistances()).containsOnly(0, 0, 0, 0, 0);
    }


    @Test
    @DisplayName("자동차 목록을 모두 전진시킬 때 목록 거리 반환 확인")
    void 자동차목록_전진_확인() {
        NumberGenerator movableRandomGenerator = new MovableRandomGenerator();
        cars.move(movableRandomGenerator);
        assertThat(cars.getDistances()).containsOnly(1, 1, 1, 1, 1);
    }
}
