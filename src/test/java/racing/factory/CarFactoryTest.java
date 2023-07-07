package racing.factory;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class CarFactoryTest {

    private static final CarFactory CAR_FACTORY = CarFactory.getInstance();

    @ParameterizedTest
    @MethodSource
    @DisplayName("올바른 자동차 이름이 입력된 경우")
    void correctInputTest(final List<String> carNames) {
        assertThatCode(() -> CAR_FACTORY.manufactureCars(carNames)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("잘못된 자동차 이름이 입력된 경우")
    void wrongInputTest(final List<String> carNames) {
        assertThatThrownBy(() -> CAR_FACTORY.manufactureCars(carNames)).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<List<String>> correctInputTest() {
        return Stream.of(
                List.of("pobi", "crong", "honux"),
                List.of("a")
        );
    }

    private static Stream<List<String>> wrongInputTest() {
        return Stream.of(
                List.of("12345", "123456"),
                List.of("a", "a"),
                List.of("  ")
        );
    }
}
