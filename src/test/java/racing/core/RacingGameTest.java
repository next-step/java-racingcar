package racing.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racing.ui.ResultView;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingGameTest {

    @ParameterizedTest
    @MethodSource("provideRandomNumberAndBoardString")
    @DisplayName("전혀 이동하지 않거나, 항상 이동한 경우 테스트")
    void runNeverOrAlways(int randomNumber, String board) {
        // given
        int numberOfCars = 3;
        int trials = 3;

        ResultView sourceResult = new ResultView(board);

        // when
        ResultView destinationResult = new RacingGame(numberOfCars, trials).run(new Random(){
            @Override
            public int nextInt(int bound) {
                return randomNumber;
            }
        });

        // then
        assertEquals(sourceResult, destinationResult);
    }

    private static Stream<Arguments> provideRandomNumberAndBoardString() {
        return Stream.of(
                Arguments.of(1, "\n\n\n\n\n\n\n\n\n\n\n\n"),
                Arguments.of(2, "\n\n\n\n\n\n\n\n\n\n\n\n"),
                Arguments.of(3, "\n\n\n\n\n\n\n\n\n\n\n\n"),
                Arguments.of(4, "-\n-\n-\n\n--\n--\n--\n\n---\n---\n---\n\n"),
                Arguments.of(5, "-\n-\n-\n\n--\n--\n--\n\n---\n---\n---\n\n"),
                Arguments.of(6, "-\n-\n-\n\n--\n--\n--\n\n---\n---\n---\n\n"),
                Arguments.of(7, "-\n-\n-\n\n--\n--\n--\n\n---\n---\n---\n\n"),
                Arguments.of(8, "-\n-\n-\n\n--\n--\n--\n\n---\n---\n---\n\n"),
                Arguments.of(9, "-\n-\n-\n\n--\n--\n--\n\n---\n---\n---\n\n")
        );
    }
}
