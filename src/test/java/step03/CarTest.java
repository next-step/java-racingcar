package step03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("DEFAULT KIND CAR 생성 테스트")
    @ParameterizedTest
    @CsvSource(value = {"-"})
    void DEFAULT_KIND_CAR_생성_테스트(String expected) {
        Car car = Car.of();
        final String result = car.position();
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("KIND CAR 생성 테스트")
    @ParameterizedTest
    @CsvSource(value = {"*:*", "((:(("}, delimiter = ':')
    void KIND_CAR_생성_테스트(String input, String expected) {
        final Car car = Car.of(input);
        final String result = car.position();
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideMovingCarResult() {
        return Stream.of(
                Arguments.of(true, "--" ),
                Arguments.of(false, "-")
        );
    }

    @DisplayName("CAR move 테스트")
    @ParameterizedTest
    @MethodSource("provideMovingCarResult")
    void CAR_이동_테스트(boolean input, String expected) {
        final Car car = Car.of();
        car.move(()->input);
        final String result = car.position();
        assertThat(result).isEqualTo(expected);
    }

}
