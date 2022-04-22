package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.util.Behavior;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarsTest {

    String[] names;

    @BeforeEach
    void beforeEach() {
        this.names = new String[]{"pobi"};
    }

    @Test
    @DisplayName("게임에 참여하는 레이싱 카의 집합 객체 생성")
    void createRacingCars() {
        assertThat(new RacingCars(this.names)).isEqualTo(new RacingCars(this.names));
    }

    @Test
    @DisplayName("회차 별 전진 혹은 정지")
    void stopOrForwardAtEachRound() {
        RacingCars racingCars = new RacingCars(this.names);
        RoundResult roundResult = racingCars.roundFight();
        assertThat(roundResult.getRoundResult().values()).containsAnyOf(Behavior.FORWARD.symbol, Behavior.STOP.symbol);
    }

    @Test
    @DisplayName("레이싱 카 이름 길이 체크")
    void racingCarsThrowZeroArgs() {
        String[] names = {"pobipobi"};
        assertThatThrownBy(() -> new RacingCars(names)).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
