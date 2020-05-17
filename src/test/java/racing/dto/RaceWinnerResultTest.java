package racing.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RaceWinnerResultTest {

    @Test
    @DisplayName("비어있는 객체로 RaceWinner 생성 시 Exception")
    void validateEmptyNames() {
        List<String> carNames = new ArrayList<>();
        assertThatThrownBy(() -> this.createRaceWinner(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("null 객체로 RaceWinner 생성 시 Exception")
    void validateNullNames() {
        List<String> carNames = null;
        assertThatThrownBy(() -> this.createRaceWinner(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private RaceWinnerResult createRaceWinner(List<String> carNames) {
        return new RaceWinnerResult(carNames);
    }

    @ParameterizedTest
    @MethodSource("provideCarNames")
    @DisplayName("winner name 반환 값 테스트")
    void getWinnerNamesTest(List<String> winnerNames) {
        RaceWinnerResult raceWinnerResult = this.createRaceWinner(winnerNames);
        assertThat(raceWinnerResult.getWinnerNames()).hasSize(winnerNames.size());
        assertThat(raceWinnerResult.getWinnerNames()).isEqualTo(winnerNames);
    }

    private static Stream<Arguments> provideCarNames() {
        return Stream.of(
                Arguments.of(Arrays.asList("test1", "test2", "test3")),
                Arguments.of(Arrays.asList("test4", "test5", "test6"))
        );
    }
}