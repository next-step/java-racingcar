package edu.nextstep.camp.model.race;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class TurnTest {
    private static final int INITIAL_TURN = 0;

    static Stream<Arguments> parseValidTurnArguments() {
        return Stream.of(
                Arguments.of(1),
                Arguments.of(10),
                Arguments.of(40),
                Arguments.of(100)
        );
    }

    @ParameterizedTest(name = "create turn: {arguments}")
    @MethodSource("parseValidTurnArguments")
    public void create(int turn) {
        assertThat(Turn.of(turn).total()).isEqualTo(turn);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -1000})
    public void createFailed(int turns) {
        assertThatIllegalArgumentException().isThrownBy(() -> Turn.of(turns));
    }

    @ParameterizedTest(name = "get current turn: {arguments}")
    @MethodSource("parseValidTurnArguments")
    public void current(int turn) {
        Turn testTurn = Turn.of(turn);
        assertThat(testTurn.current()).isEqualTo(INITIAL_TURN);
    }

    @ParameterizedTest(name = "go to next turn: {arguments}")
    @MethodSource("parseValidTurnArguments")
    public void next(int turn) {
        Turn testTurn = Turn.of(turn);
        for (int i = 0; i < turn; i++) {
            assertThat(testTurn.current()).isEqualTo(i);
            testTurn.next();
            assertThat(testTurn.current()).isEqualTo(i + 1);
        }
    }


    @ParameterizedTest(name = "check end: {arguments}")
    @MethodSource("parseValidTurnArguments")
    public void isEnded(int turn) {
        Turn testTurn = Turn.of(turn);
        for (int i = 0; testTurn.hasNext(); i++) {
            assertThat(testTurn.hasNext()).isTrue();
            assertThat(testTurn.current()).isEqualTo(i);
            testTurn.next();
            assertThat(testTurn.current()).isEqualTo(i + 1);
        }

        assertThat(testTurn.hasNext()).isFalse();
    }
}
