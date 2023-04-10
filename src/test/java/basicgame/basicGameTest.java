package basicgame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class basicGameTest {

    @DisplayName("전진 가능 여부 테스트")
    @MethodSource("isEnoughToGoTestArguments")
    @ParameterizedTest
    void isEnoughToGoTest(int value, boolean expected) {
        Car car = new Car(new StringBuffer());

        boolean actual = car.isEnoughValue(value);

        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> isEnoughToGoTestArguments() {
        return Stream.of(
                Arguments.of(-5, false),
                Arguments.of(-4, false),
                Arguments.of(-3, false),
                Arguments.of(-2, false),
                Arguments.of(-1, false),
                Arguments.of(0, false),
                Arguments.of(1, false),
                Arguments.of(2, false),
                Arguments.of(3, false),
                Arguments.of(4, true),
                Arguments.of(5, true),
                Arguments.of(6, true),
                Arguments.of(7, true),
                Arguments.of(8, true),
                Arguments.of(9, true)
        );
    }

    @Test
    @DisplayName("자동차 대수, 시도 횟수 입력 테스트 Success")
    void inputUiTestSuccess() {
        String input = "3\n5\n"; // 입력할 값

        int expectedCarCount = 3;
        int expectedTryCount = 5;

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        RacingCar.input();

        assertThat(RacingCar.getCarCount()).isEqualTo(expectedCarCount);
        assertThat(RacingCar.getTryCount()).isEqualTo(expectedTryCount);
    }

    @Test
    @DisplayName("자동차 대수, 시도 횟수 입력 테스트 Fail")
    void inputUiTestFailure() {
        String input = "-1\n5\n"; // 입력할 값

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> RacingCar.input()).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RacingCar.INPUT_ERROR_MESSAGE);
    }
}
