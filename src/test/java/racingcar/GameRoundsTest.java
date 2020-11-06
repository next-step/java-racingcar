package racingcar;

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
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class GameRoundsTest {

    static Stream<Arguments> isGameEnd() {
        return Stream.of(
                arguments(0, true),
                arguments(1, false)
        );
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
        List<String> names = Arrays.asList("pobi", "crong", "honux");
        int roundNum = 0;
        Cars cars = new Cars(names);
        GameRounds gameRounds = new GameRounds(roundNum);

        gameRounds.keepRecord(cars);

        int roundToGet = 0;
        Record record = gameRounds.getRecords().getRecordList().get(roundToGet);
        assertThat(record.getPositions()).hasSize(names.size());
        record.getPositions().forEach(position -> assertThat(position).isEqualTo(Car.INITIAL_POSITION));
    }
}
