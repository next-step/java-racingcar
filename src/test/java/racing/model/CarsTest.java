package racing.model;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.fake.FakeNumberGenerator;

class CarsTest {
    private Cars cars;

    @DisplayName("리스트 안의 모든 자동차를 움직일 수 있다.")
    @Test
    void moveAllTest() {
        // given
        cars = new Cars(makeDummyCars(3), new FakeNumberGenerator());

        // when
        cars.moveAll();

        // then
        assertThat(cars.getPositions()).isEqualTo(Arrays.asList(1, 1, 1));
    }

    private List<Car> makeDummyCars(int carCount) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }
        return carList;
    }
}
