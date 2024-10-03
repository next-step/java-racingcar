package step3.model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void 자동차들_객체_생성() {
        String carNames = "hwan,hwan2,hwan3";
        Cars cars = Cars.from(carNames);

        assertThat(cars.getCars()).hasSize(3);
    }

    @Test
    void 자동차들_전진_확인() {
        String carNames = "hwan,hwan2,hwan3";
        Cars cars = Cars.from(carNames);

        MoveStrategy moveStrategy = new MoveStrategy();
        for (int i = 0; i < 100; i++) {
            cars.moveCars(moveStrategy);
        }

        List<Integer> movements = cars.getCars().stream()
                .map(Car::getMovement)
                .collect(Collectors.toList());

        assertThat(movements).anyMatch(movement -> movement > 0);
    }

    @Test
    void 우승자_생성_확인() {
        String carNames = "hwan,hwan2,hwan3";
        Cars cars = Cars.from(carNames);


    }
}
