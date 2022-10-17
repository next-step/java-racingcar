package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.dto.GameResultDto;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class RoundResultsTest {

    @Test
    void add() {
        GameResultDto gameResultDto = new GameResultDto();
        Cars cars = Cars.namesOf(List.of("a", "b", "c"));

        gameResultDto.recordRoundResults(cars);

        assertThat(gameResultDto.getRoundResults().stream()
                .map(carResultDtos -> carResultDtos.stream()
                        .map(carResultDto -> carResultDto.position)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList()))
                .isEqualTo(List.of(List.of(0, 0, 0)));
    }
}
