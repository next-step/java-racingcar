package step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step3.Car;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private step3.Car car = null;

    @BeforeEach
    public void setUp() {
        car = new Car();
    }

    @DisplayName("현재의 위치값을 반환")
    @Test
    public void getPositionTest() {
        int position = car.getPosition();
        assertThat(position).isEqualTo(0);
    }

    @DisplayName("위치값을 변경하고 그에 따른 값 반환 테스트")
    @Test
    public void changePostionandGetPosition() {
        car.goPosition();
        int position = car.getPosition();
        assertThat(position).isEqualTo(1);
    }

    @DisplayName("4보다 큰값인지 아닌지 확인")
    @ParameterizedTest
    @MethodSource
    public void isGreaterTest(int input, boolean expected) {

        boolean result = car.canGo(input);

        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> isGreaterTest() {
        return Stream.of(
                Arguments.of(4, true),
                Arguments.of(5, true),
                Arguments.of(0, false)
        );
    }

}