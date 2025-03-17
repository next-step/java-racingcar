package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarsTest {
    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars(3);
    }

    @Test
    @DisplayName("생성된 자동차의 개수를 확인한다.")
    void initialize() {
        assertEquals(3, cars.getCars().size());
    }

}