package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car = null;

    @BeforeEach
    public void setUp() {
        car = new Car("HO", 1);
    }


    @DisplayName("입력값이 4미만 포지션의 위치값 변화 없음")
    @Test
    public void moveLessCondition() {
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(1);

    }

    @DisplayName("입력값이 4이상일때 위치값 변화 있음")
    @Test
    public void moveGreaterCondition() {
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(2);

    }

    @DisplayName("외부에서 입력한 최대값과 동일한지 비교")
    @ParameterizedTest
    @MethodSource
    public void isSamePosition(int input, boolean result) {
        boolean checkResult = car.isSamePosition(input);
        assertThat(checkResult).isEqualTo(result);
    }

    private static Stream<Arguments> isSamePosition() {
        return Stream.of(
                Arguments.of(1, true),
                Arguments.of(2, false));
    }

}