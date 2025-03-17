package racing.model;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.fake.FakeNumberGenerator;

class CarsTest {
    private static final int MOVE_NUMBER = 4;
    private static final int STOP_NUMBER = 3;
    private Cars cars;

    @DisplayName("리스트 안의 모든 자동차를 움직일 수 있다.")
    @Test
    void moveAllTest() {
        // given
        cars = new Cars(makeDummyCars(3), new FakeNumberGenerator(MOVE_NUMBER));

        // when
        cars.moveAll();

        // then
        assertThat(cars.getPositions()).isEqualTo(Arrays.asList(1, 1, 1));
    }

    @DisplayName("리스트 안의 모든 자동차들의 현재 위치를 알 수 있다.")
    @Test
    void getPositionsTest() {
        // given
        cars = new Cars(makeDummyCars(7), new FakeNumberGenerator(STOP_NUMBER));

        // when
        List<Integer> positions = cars.getPositions();

        // then
        Assertions.assertAll(() -> assertThat(positions).isNotNull(),
                () -> assertThat(positions).containsExactly(0, 0, 0, 0, 0, 0, 0));
    }

    @DisplayName("일급 콜렉션 안의 리스트의 총 개수를 알 수 있다.")
    @Test
    void sizeTest() {
        // given
        cars = new Cars(makeDummyCars(5), new FakeNumberGenerator(MOVE_NUMBER));

        // when
        // then
        assertThat(cars.size()).isEqualTo(5);
    }

    private List<Car> makeDummyCars(int carCount) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }
        return carList;
    }
}
