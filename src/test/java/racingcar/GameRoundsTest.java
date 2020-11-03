package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
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
    @DisplayName("record가져오기")
    void getRecords() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(null));
        cars.add(new Car(null));

        GameRounds gameRounds = new GameRounds(0);
        Record record = gameRounds.getRecord(cars);

        assertThat(record.getPositions()).containsExactly(0, 0);
    }
}
