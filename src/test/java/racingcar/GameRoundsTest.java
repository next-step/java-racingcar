package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class GameRoundsTest {
    List<String> carNames;

    static Stream<Arguments> isGameEnd() {
        return Stream.of(
                arguments(0, true),
                arguments(1, false)
        );
    }

    @BeforeEach
    void setUp() {
        carNames = Arrays.asList("pobi", "crong", "honux");
    }

    @ParameterizedTest
    @DisplayName("게임 종료 확인")
    @MethodSource
    void isGameEnd(int roundNum, boolean gameEnd) {
        GameRounds gameRounds = new GameRounds(roundNum);

        assertThat(gameRounds.isGameEnd()).isEqualTo(gameEnd);
    }

    @Test
    @DisplayName("라운드 종료")
    void endRound() {
        int roundNum = 2;
        GameRounds gameRounds = new GameRounds(roundNum);

        IntStream.range(0, roundNum).forEach(round -> gameRounds.endRound());

        assertThat(gameRounds.isGameEnd()).isEqualTo(true);
    }

    @Test
    @DisplayName("기록 저장하기")
    void keepRecord() {
        int roundNum = 0;
        Cars cars = new Cars(carNames);
        GameRounds gameRounds = new GameRounds(roundNum);

        gameRounds.keepRecord(cars);

        int roundToGet = 0;
        int recordCount = 1;
        List<RoundRecord> roundRecordList = gameRounds.getRecords().getRoundRecordList();
        assertThat(roundRecordList).hasSize(recordCount);
        assertThat(roundRecordList.get(roundToGet).getRecord())
                .containsExactly(
                        entry("pobi", Car.INITIAL_POSITION),
                        entry("crong", Car.INITIAL_POSITION),
                        entry("honux", Car.INITIAL_POSITION)
                );
    }
}
