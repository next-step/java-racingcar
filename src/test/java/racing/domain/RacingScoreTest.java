package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("레이싱 자동차 스코어 객체 관련 테스트")
class RacingScoreTest {

    @Test
    @DisplayName("레이싱 결과를 저장한다.")
    void racing_score() {

        final RacingScore racingScore = RacingScore.init();
        final List<RacingCar> oneRound = List.of(new RacingCar(new CarName("pobi"), 0)
                , new RacingCar(new CarName("line"), 1)
        );
        final RacingCars racingCars = new RacingCars(oneRound);

        racingScore.save(racingCars);

        assertAll(
                () -> assertThat(racingScore.findByIndex(0)).hasSize(2),
                () -> assertThat(racingScore.findByIndex(0).get(0)).isEqualTo(oneRound.get(0))
        );

    }
}
