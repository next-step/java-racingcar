package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class GameRoundsTest {

    @ParameterizedTest
    @DisplayName("게임 종료 확인")
    @MethodSource
    void isGameEnd(int roundNum, boolean gameEnd) {
        GameRounds gameRounds = new GameRounds(roundNum);

        assertThat(gameRounds.isGameEnd()).isEqualTo(gameEnd);
    }

    static Stream<Arguments> isGameEnd() {
        return Stream.of(
                arguments(0, true),
                arguments(1, false)
        );
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
        int carNum = 2;
        int roundNum = 3;
        Cars cars = new Cars(carNum, null);
        GameRounds gameRounds = new GameRounds(0);

        IntStream.range(0, roundNum).forEach(idx -> gameRounds.keepRecord(cars));
        List<Record> recordList = gameRounds.getRecords().getRecordList();

        assertThat(recordList).hasSize(roundNum);
        recordList.stream().forEach(record -> {
            assertThat(record.getPositions()).hasSize(carNum);
            record.getPositions().forEach(position -> assertThat(position).isEqualTo(0));
        });
    }
}
