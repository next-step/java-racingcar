package racing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import step3.domain.RacingGame;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class RacingGameTest {
    @ParameterizedTest
    @CsvSource(value = {"1:1", "200:3", "4:6", "4:100"}, delimiter = ':')
    void validCarCntAndTimeTest(int carCnt, int time) {
        RacingGame racingGame = new RacingGame(carCnt, time);
    }

    @ParameterizedTest
    @CsvSource(value = {"-1:1", "200:0", "0:6", "4:-100"}, delimiter = ':')
    void invalidCarCntAndTimeTest(int carCnt, int time) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    RacingGame racingGame = new RacingGame(carCnt, time);
                });
    }

    @ParameterizedTest
    @MethodSource("carAndTimeProvider")
    void isRangeInTime(int carCnt, int time) {
        RacingGame racingGame = new RacingGame(carCnt, time);
        racingGame.racingStart();
        assertThat(racingGame.getCarPositions()).doesNotContain(time + 1);
    }

    static Stream<Arguments> carAndTimeProvider() {
        return Stream.of(
                arguments(7,100),
                arguments(1,20),
                arguments(9,3),
                arguments(10,22));
    }

    @Test
    void racingGameWithNameTest() {
        RacingGame racingGame = new RacingGame("dayun,kk", 3);
        racingGame.racingStart();
        assertThat(racingGame.getCarPositions()).doesNotContain(4);
    }

    @Test
    void getRecordTest() {
        RacingGame racingGame = new RacingGame(1, 1);
        racingGame.racingStart();
        Map<Integer, int[]> record1 = racingGame.getRecord();
        int[] recordValue1 = record1 .get(0);
        recordValue1[0] = 100;
        System.out.println(Arrays.toString(recordValue1));

        Map<Integer, int[]> record2 = racingGame.getRecord();
        int[] recordValue2 = record2 .get(0);
        System.out.println(Arrays.toString(recordValue2));
        assertThat(recordValue2[0]).isEqualTo(0);
    }
}
