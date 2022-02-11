package racingcar.model.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
    void forwardCarTest(int nonMove) {
        assertThat(car.getStep()).isEqualTo(nonMove);
    }

    @DisplayName("자동차_이름_테스트")
    @ParameterizedTest
    @ValueSource(strings = "a")
    void getCarNameTest(String carName) {
        assertThat(car.getName()).isEqualTo(carName);
    }

    @DisplayName("자동차_이름_길이_테스트")
    @ParameterizedTest
    @ValueSource(strings = "abcdef")
    void getCarNameLengthTest(String carName) {
        assertThatIllegalArgumentException().isThrownBy(()-> new Car(carName));
    }
}
