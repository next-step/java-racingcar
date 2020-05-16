package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racing.dto.RaceInformation;
import racing.dto.RacingGameResult;
import racing.service.RacingGameService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameServiceTest {

    @ParameterizedTest
    @MethodSource("provideRaceInformation")
    @DisplayName("RacingGameResult 개수 검증")
    void racingGameResultCountTest(RaceInformation raceInformation) {
        RacingGameService racingGameService = this.createRacingGameService();
        List<RacingGameResult> racingGameResults = racingGameService.executeRace(raceInformation);
        assertThat(racingGameResults).hasSize(raceInformation.getTotalRacingCount());
    }

    @ParameterizedTest
    @MethodSource("provideRaceInformation")
    @DisplayName("RacingGameResult carNames 검증")
    void  racingGameResultCarNamesTest(RaceInformation raceInformation) {
        RacingGameService racingGameService = this.createRacingGameService();
        List<RacingGameResult> racingGameResults = racingGameService.executeRace(raceInformation);
        List<String> carNames = racingGameResults.stream()
                .flatMap(racingGameResult -> racingGameResult.getCarRaceResults().stream())
                .map(carRaceResult -> carRaceResult.getCarName())
                .distinct()
                .collect(Collectors.toList());

        assertThat(carNames).isEqualTo(Arrays.asList(raceInformation.getCarNames()));
    }

    private static Stream<Arguments> provideRaceInformation() {
        return Stream.of(
                Arguments.of(new RaceInformation(5, new String[] {"a", "b"})),
                Arguments.of(new RaceInformation(3, new String[] {"b", "c"}))
        );
    }

    @Test
    @DisplayName("RaceInformation null일 경우 Exception")
    void validateNullRaceInformation() {
        RacingGameService racingGameService = this.createRacingGameService();
        assertThatThrownBy(() -> racingGameService.executeRace(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private RacingGameService createRacingGameService() {
        return new RacingGameService();
    }
}
