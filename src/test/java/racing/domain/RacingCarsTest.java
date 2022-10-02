package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("레이싱 게임 참여 자동차들 객체 관련 테스트")
class RacingCarsTest {

    @DisplayName("참여한 자동차가 이동여부의 따라 이동 스코어를 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"true,1", "false,0"})
    void round_play(final boolean result, final int score) {

        final List<RacingCar> racingCarList = List.of(new RacingCar(new CarName("d1")));
        final RacingCars racingCars = new RacingCars(racingCarList);
        final RacingScore racingScore = RacingScore.init();
        racingCars.enter(racingScore, () -> result);
        final List<RacingCar> racingCarScore = racingCars.score();

        assertThat(racingCarScore.get(0).getPosition()).isEqualTo(score);
    }
}
