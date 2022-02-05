package racingcar.model.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    private static Car car;

    @BeforeEach
    void initTest() {
        car = new Car("a");
    }

    @DisplayName("자동차_전진_여부_테스트")
    @ParameterizedTest
    @ValueSource(ints = 1)
    void moveForwardTest(int moveNumber) {
        car.moveForward();
        assertThat(car.getStep()).isEqualTo(moveNumber);
    }


    @DisplayName("자동차_전진_최대값_테스트")
    @ParameterizedTest
    @ValueSource(ints = 1)
    void isMaxTest(int max) {
        car.moveForward();
        assertTrue(car.isMax(max));
    }

    @DisplayName("자동차_전진_테스트")
    @ParameterizedTest
    @ValueSource(ints = 0)
    void carForwardTest(int nonMove) {
        assertThat(car.getStep()).isEqualTo(nonMove);
    }

    @DisplayName("자동차_이름_테스트")
    @ParameterizedTest
    @ValueSource(strings = "a")
    void carNameTest(String carName) {
        assertThat(car.getName()).isEqualTo(carName);
    }
}
