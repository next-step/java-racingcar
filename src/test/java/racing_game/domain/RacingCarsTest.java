package racing_game.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing_game.model.RoundResult;
import racing_game.util.Behavior;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarsTest {

    final int totalRacingCarCount = 3;

    @Test
    @DisplayName("게임에 참여하는 레이싱 카의 집합 객체 생성")
    void createRacingCars() {
        assertThat(new RacingCars(totalRacingCarCount)).isInstanceOf(RacingCars.class);
    }

    @Test
    @DisplayName("회차 별 전진 혹은 정지")
    void stopOrForwardAtEachRound() {
        RacingCars racingCars = new RacingCars(totalRacingCarCount);
        RoundResult roundResult = racingCars.roundFight();
        assertThat(roundResult.getRoundResult().values()).containsAnyOf(Behavior.FORWARD.symbol, Behavior.STOP.symbol);
    }

    @Test
    @DisplayName("참여 레이싱 카 0대에 대한 예외 처리")
    void racingCarsThrowZeroArgs() {
        assertThatThrownBy(() -> new RacingCars(0)).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
