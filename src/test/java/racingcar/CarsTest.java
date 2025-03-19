package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarsTest {
    private Cars cars;

    @BeforeEach
    void setUp() {
        String[] carNames = {"pobi", "crong", "honux"};
        cars = new Cars(carNames);
    }

    @Test
    @DisplayName("생성된 자동차의 개수를 확인한다.")
    void initialize() {
        assertEquals(3, cars.getCars().size());
    }

    @Test
    @DisplayName("빈 자동차에서 최대 거리를 구하려는 경우 예외를 발생시킨다.")
    public void emptyCars() {
        Cars cars = new Cars(new String[]{});
        assertThatThrownBy(cars::getMaxDistance)
                .isInstanceOf(RuntimeException.class);
    }
}