package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.random.RacingGameRandomNumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameResultsTest {
    @Test
    @DisplayName("레이싱 결과 목록 추가를 할 수 있다.")
    void testAddResult() {
        final RacingCars racingCars = RacingCars.create(
            List.of(
                new RacingCar(new RacingGameRandomNumberGenerator(), "1번자동차"),
                new RacingCar(new RacingGameRandomNumberGenerator(), "2번자동차")
            )
        );

        final RacingGameResults results = new RacingGameResults();
        results.add(new RacingGameResult(racingCars));
        results.add(new RacingGameResult(racingCars));

        assertThat(results.size()).isEqualTo(2);
    }
}