package step_3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step_3.model.RoundResult;
import step_3.util.Behavior;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarsTest {

    final int totalRacingCarCount = 3;
    List<RacingCar> racingCarList;

    @BeforeEach
    void beforeEach() {
        this.racingCarList = Stream.generate(RacingCar::new)
                .limit(this.totalRacingCarCount)
                .collect(Collectors.toList());
    }

    @Test
    @DisplayName("게임에 참여하는 레이싱 카의 집합 객체 생성")
    void createRacingCars() {
        assertThat(new RacingCars(racingCarList)).isInstanceOf(RacingCars.class);
    }

    @Test
    @DisplayName("회차 별 전진 혹은 정지")
    void stopOrForwardAtEachRound() {
        RacingCars racingCars = new RacingCars(racingCarList);
        RoundResult roundResult = racingCars.roundFight();
        assertThat(roundResult.getBehaviorByRacingCarId().values()).containsAnyOf(Behavior.values());
    }

    @Test
    @DisplayName("빈 레이킹 카 리스트 주입 시 예외 처리")
    void racingCarsThrowNegativeArg() {
        assertThatThrownBy(() -> new RacingCars(null)).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("참여 레이싱 카 0대에 대한 예외 처리")
    void racingCarsThrowZeroArgs() {
        assertThatThrownBy(() -> new RacingCars(new ArrayList<>())).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
