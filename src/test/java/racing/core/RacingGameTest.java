package racing.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingGameTest {

    private static int numberOfCars = 3;
    private static int trials = 3;

    @ParameterizedTest
    @MethodSource("provideRandomNumberAndBoardString")
    @DisplayName("전혀 이동하지 않거나, 항상 이동한 경우 테스트")
    void runNeverOrAlways(int randomNumber, List<Snapshot> result) {
        List<Snapshot> snapshots = new RacingGame(numberOfCars, trials).run(new Random() {
            @Override
            public int nextInt(int bound) {
                return randomNumber;
            }
        });
        assertEquals(snapshots, result);
    }

    private static Stream<Arguments> provideRandomNumberAndBoardString() {
        List<Snapshot> never = new ArrayList<>();
        for (int i = 0; i < numberOfCars * trials; i++) {
            never.add(new Snapshot(0));
        }

        List<Snapshot> always = Arrays.asList(
                new Snapshot(1), new Snapshot(1), new Snapshot(1),
                new Snapshot(2), new Snapshot(2), new Snapshot(2),
                new Snapshot(3), new Snapshot(3), new Snapshot(3)
        );

        return Stream.of(
                Arguments.of(1, never),
                Arguments.of(2, never),
                Arguments.of(3, never),
                Arguments.of(4, always),
                Arguments.of(5, always),
                Arguments.of(6, always),
                Arguments.of(7, always),
                Arguments.of(8, always),
                Arguments.of(9, always)
        );
    }
}
