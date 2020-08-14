package racing.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car = new Car();

    @Test
    @DisplayName("이동 성공 테스트")
    void moveSuccess() {
        Move movement = new AlwaysMove();
        assertThat(car.move(movement)).isEqualTo(new Snapshot(1));
    }

    @Test
    @DisplayName("이동 실패 테스트")
    void moveFailed() {
        Move movement = new NeverMove();
        assertThat(car.move(movement)).isEqualTo(new Snapshot(0));
    }

    @ParameterizedTest
    @MethodSource("provideArrayOfMoveAndActual")
    @DisplayName("car 객체 하나가 이동한 총 거리 테스트")
    void snapshot(Move[] movements, Snapshot expected) {
        Snapshot actual = null;
        for (Move m : movements) {
            actual = car.move(m);
        }
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideArrayOfMoveAndActual() {
        Move never = new NeverMove();
        Move always = new AlwaysMove();

        return Stream.of(
                Arguments.of(new Move[] {always, always, always}, new Snapshot(3)),
                Arguments.of(new Move[] {never, never, never, never, never}, new Snapshot(0)),
                Arguments.of(new Move[] {always, always, always, always, always}, new Snapshot(5)),
                Arguments.of(new Move[] {never, never, never, always}, new Snapshot(1))
        );
    }
}

