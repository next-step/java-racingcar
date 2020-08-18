package racing.core.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racing.core.domain.Car;
import racing.core.dto.TrackInfo;
import racing.core.patterns.MoveStrategy;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarTest {

    private static String carName = "test";
    private Car car;

    @BeforeEach
    private void setUp() {
        car = new Car(carName);
    }

    @Test
    @DisplayName("이동 성공 테스트")
    void moveSuccess() {
        assertThat(car.move(() -> true)).isEqualTo(new TrackInfo(carName, 1));
    }

    @Test
    @DisplayName("이동 실패 테스트")
    void moveFailed() {
        assertThat(car.move(() -> false)).isEqualTo(new TrackInfo(carName, 0));
    }

    @ParameterizedTest
    @MethodSource("provideArrayOfMoveAndActual")
    @DisplayName("car 객체 하나가 이동한 총 거리 테스트")
    void snapshot(MoveStrategy[] movements, TrackInfo expected) {
        TrackInfo actual = null;
        for (MoveStrategy m : movements) {
            actual = car.move(m);
        }
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideArrayOfMoveAndActual() {
        MoveStrategy never = () -> false;
        MoveStrategy always = () -> true;

        return Stream.of(
                Arguments.of(new MoveStrategy[] {always, always, always}, new TrackInfo(carName, 3)),
                Arguments.of(new MoveStrategy[] {never, never, never, never, never}, new TrackInfo(carName, 0)),
                Arguments.of(new MoveStrategy[] {always, always, always, always, always}, new TrackInfo(carName, 5)),
                Arguments.of(new MoveStrategy[] {never, never, never, always}, new TrackInfo(carName, 1))
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "가나다라마바", "123456", "----*("})
    void 자동차_이름_5글자_초과_테스트(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Car actual = new Car(name);
        }).withMessage("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 자동차_이름_빈_문자열_테스트(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Car actual = new Car(name);
        }).withMessage("자동차 이름은 반드시 문자나 숫자를 포함해야 합니다.");
    }
}

