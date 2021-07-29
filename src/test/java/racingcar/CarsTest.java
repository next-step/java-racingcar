package racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    Cars cars;

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void 입렵_받은_숫자_만큼_car_객체를_생성한다(int createCount) {
        cars = new Cars(createCount);
        int actual = cars.getCarsSize();
        int expected = createCount;
        assertThat(actual).isEqualTo(expected);
    }

}