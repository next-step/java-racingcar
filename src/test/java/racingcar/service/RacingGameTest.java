package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    @DisplayName("자동차 대수에 맞게 초기화한다.")
    void 자동차_초기화() {
        List<RacingCar> racingCars = RacingGame.getInstance().createRacingCars(4);
        assertThat(racingCars).hasSize(4);
    }

    @Test
    @DisplayName("자동차의 상태를 전달한다.")
    void 자동차_상태_전달() {
        List<RacingCar> racingCars = RacingGame.getInstance().createRacingCars(2);
        assertThat(RacingGame.getInstance().getRacingCarsPosition(racingCars)).isEqualTo(Arrays.asList(1, 1));
    }

    @Test
    @DisplayName("매치를 진행하면 match가 감소한다.")
    void 매치_카운트_감소() {
        int currentCount = RacingGame.getInstance().match(5, new ArrayList<>());
        assertThat(currentCount).isEqualTo(4);
    }

    @Test
    @DisplayName("매치가 종료되면 false를 반환한다.")
    void 매치_종료() {
        assertThat(RacingGame.getInstance().isMatching(0)).isFalse();
    }

    @Test
    @DisplayName("매치가 진행중이면 true를 반환한다.")
    void 매치_진행() {
        assertThat(RacingGame.getInstance().isMatching(1)).isTrue();
    }
}
