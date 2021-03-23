package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.strategy.MoveStrategy;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static racingcar.exception.Message.MAX_LENGTH_ERROR;
import static racingcar.exception.Message.NULL_OR_EMPTY_ERROR;

class CarTest {
    private final static String carName = "test";
    Car car;

    static Stream<Arguments> distances() {
        return Stream.of(
                Arguments.of(new MoveStrategy[]{() -> false, () -> false, () -> false}, new Car(carName, 0)),
                Arguments.of(new MoveStrategy[]{() -> true, () -> true, () -> true}, new Car(carName, 3)),
                Arguments.of(new MoveStrategy[]{() -> true, () -> false, () -> true}, new Car(carName, 2))
        );
    }

    static Stream<Arguments> namingError() {
        String wrongName = "abcdef";
        return Stream.of(
                arguments(null, NULL_OR_EMPTY_ERROR),
                arguments("", NULL_OR_EMPTY_ERROR),
                arguments(wrongName, MAX_LENGTH_ERROR)
        );
    }

    @BeforeEach
    void setCar() {
        car = new Car(carName);
    }

    @Test
    @DisplayName("전진 테스트")
    void moveTrue() {
        assertThat(car.move(() -> true)).isEqualTo(new Car(carName, 1));
    }

    @Test
    @DisplayName("멈춤 테스트")
    void moveFalse() {
        assertThat(car.move(() -> false)).isEqualTo(new Car(carName, 0));
    }

    @ParameterizedTest
    @DisplayName("이동거리 확인 테스트")
    @MethodSource("distances")
    void checkPosition(MoveStrategy[] positions, Car expected) {
        for (MoveStrategy moveStrategy : positions) {
            car = car.move(moveStrategy);
        }
        assertEquals(expected, car);
    }

    @ParameterizedTest
    @DisplayName("5자 이하의 이름을 가진 자동차 생성 테스트")
    @ValueSource(strings = {"pobi", "crong", "honux"})
    void createCarWithName(String name) {
        car = new Car(name);
        assertThat(car.getName()).isEqualTo(name);
    }

    @ParameterizedTest
    @DisplayName("공백, 5자 초과 시 예외 리턴 테스트")
    @MethodSource("namingError")
    void createCarWithWrongName(String name, String errorMessage) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car(name))
                .withMessage(errorMessage);
    }
}
