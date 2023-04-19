package racing.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.model.move.MoveStrategy;
import racing.model.move.RandomMoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("입력한 숫자만큼 자동차 생성")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5})
    void createCarsTest(int number) {
        Cars cars = new Cars(number, new RandomMoveStrategy());

        assertThat(cars.getCars()).hasSize(number);
    }


}
