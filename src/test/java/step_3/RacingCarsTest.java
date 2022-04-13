package step_3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarsTest {

    final int totalRounds = 5;
    final int totalRacingCarCount = 3;

    @Test
    @DisplayName("게임에 참여하는 레이싱 카의 집합 객체 생성")
    void createRacingCars() {
        assertThat(new RacingCars(totalRounds, totalRacingCarCount)).isInstanceOf(RacingCars.class);
    }

    @Test
    @DisplayName("회차 별 전진 혹은 정지")
    void stopOrForwardAtEachRound() {
        RacingCars racingCars = new RacingCars(totalRounds, totalRacingCarCount);
        assertThat(racingCars.roundFight(0)).containsAnyOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    @Test
    @DisplayName("각 레이싱 카 별 최종 전진 횟수")
    void totalForwardHistory() {
        RacingCars racingCars = new RacingCars(totalRounds, totalRacingCarCount);
        IntStream.range(0, totalRounds).forEach(racingCars::roundFight);
        assertThat(racingCars.totalForwardHistory()).containsAnyOf(0, 1, 2, 3, 4);
    }

    @Test
    @DisplayName("레이싱 카 집합 객체 생성 시, 음수 예외 처리")
    void racingCarsThrowNegativeArg() {
        assertThatThrownBy(() -> new RacingCars(-1, 1)).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("레이싱 카 집합 객체 생성 시, 참여 레이싱 카 0대에 대한 예외 처리")
    void racingCarsThrowZeroArgs() {
        assertThatThrownBy(() -> new RacingCars(0, 0)).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
