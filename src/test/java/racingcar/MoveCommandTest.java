package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.MoveCommand;
import racingcar.domain.MoveType;
import racingcar.utils.TestNumber;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoveCommandTest {
    @ParameterizedTest
    @MethodSource("provideValidMoveNumber")
    @DisplayName("0 ~ 3 일 경우 정지하고, 4 ~ 9 일 경우 앞으로 가라고 명령하는 지 테스트")
    public void testMoveCommandUsingValidNumber(int number, MoveType expected) {
        MoveCommand moveCommand = new MoveCommand(new TestNumber(number));

        assertThat(moveCommand.command()).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    @DisplayName("0~9를 벗어나는 숫자일 경우 예외 발생")
    public void testMoveCommandUsingInvalidNumber(int number) {
        MoveCommand moveCommand = new MoveCommand(new TestNumber(number));

        assertThatThrownBy(moveCommand::command).isInstanceOf(RuntimeException.class);
    }

    private static Stream<Arguments> provideValidMoveNumber() {
        return Stream.concat(provideStopMoveNumber(), provideForwardMoveNumber());
    }

    private static Stream<Arguments> provideStopMoveNumber() {
        return Stream.of(
                Arguments.of(0, MoveType.STOP),
                Arguments.of(1, MoveType.STOP),
                Arguments.of(2, MoveType.STOP),
                Arguments.of(3, MoveType.STOP)
        );
    }

    private static Stream<Arguments> provideForwardMoveNumber() {
        return Stream.of(
                Arguments.of(4, MoveType.FORWARD),
                Arguments.of(5, MoveType.FORWARD),
                Arguments.of(6, MoveType.FORWARD),
                Arguments.of(7, MoveType.FORWARD),
                Arguments.of(8, MoveType.FORWARD),
                Arguments.of(9, MoveType.FORWARD)
        );
    }

}
