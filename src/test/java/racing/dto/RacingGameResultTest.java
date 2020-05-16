package racing.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameResultTest {

    @ParameterizedTest
    @MethodSource("provideNotValidNames")
    @DisplayName("비어있는 cars 객체로 생성했을 경우 Exception")
    void validateGameResultByEmptyName(List<CarRaceResult> carRaceResults, int position) {
        assertThatThrownBy(() -> this.createRacingGameResult(carRaceResults, position))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideNotValidNames() {
        return Stream.of(
                Arguments.of(new ArrayList<>(), 1),
                Arguments.of(null, 1)
        );
    }

    private RacingGameResult createRacingGameResult(List<CarRaceResult> carRaceResults, int position) {
        return new RacingGameResult(carRaceResults, position);
    }
}
