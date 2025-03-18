package racing.model;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.fake.FakeNumberGenerator;
import racing.service.NumberGenerator;

class CarsTest {
    private static final int MOVE_NUMBER = 4;
    private static final int STOP_NUMBER = 3;

    @DisplayName("Cars 객체를 생성 할 수 있다.")
    @Test
    void createTest() {
        String[] carNames = {"BMW"};
        Cars cars = createCars(carNames, new FakeNumberGenerator(MOVE_NUMBER));

        assertAll(() -> assertThat(cars.getCars()).hasSize(1),
                () -> assertThat(cars.getCars().get(0).getPosition()).isEqualTo(1));
    }

    @DisplayName("모든 자동차 객체를 움직일 수 있다.")
    @Test
    void movedAllTest() {
        // given
        String[] carNames = {"BMW", "AUDI"};
        Cars cars = createCars(carNames, new FakeNumberGenerator(MOVE_NUMBER));

        // when
        Cars sut = cars.movedAll();

        // then
        assertAll(() -> assertThat(sut.getCars().get(0).getPosition()).isEqualTo(2),
                () -> assertThat(sut.getCars().get(1).getPosition()).isEqualTo(2)
        );
    }

    @DisplayName("리스트 안의 모든 자동차의 정보를 가져올 수 있다.")
    @Test
    void getCarsTest() {
        // given
        String[] carNames = {"BMW", "AUDI", "BENZ"};
        Cars cars = createCars(carNames, new FakeNumberGenerator(STOP_NUMBER));

        // when
        List<Car> carList = cars.getCars();

        // then
        assertThat(carList).extracting("position").containsExactly(1, 1, 1);
    }

    private Cars createCars(String[] carNames, NumberGenerator numberGenerator) {
        return Cars.create(carNames, numberGenerator);
    }
}
