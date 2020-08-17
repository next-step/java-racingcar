package racing.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racing.core.domain.Car;
import racing.core.dto.TrackInfo;
import racing.core.patterns.MoveStrategy;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car = new Car("test");

    @Test
    @DisplayName("이동 성공 테스트")
    void moveSuccess() {
        assertThat(car.move(() -> true)).isEqualTo(new TrackInfo(1));
    }

    @Test
    @DisplayName("이동 실패 테스트")
    void moveFailed() {
        assertThat(car.move(() -> false)).isEqualTo(new TrackInfo(0));
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
                Arguments.of(new MoveStrategy[] {always, always, always}, new TrackInfo(3)),
                Arguments.of(new MoveStrategy[] {never, never, never, never, never}, new TrackInfo(0)),
                Arguments.of(new MoveStrategy[] {always, always, always, always, always}, new TrackInfo(5)),
                Arguments.of(new MoveStrategy[] {never, never, never, always}, new TrackInfo(1))
        );
    }
}

