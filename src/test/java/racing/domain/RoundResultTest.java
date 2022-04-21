package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.RacingCar.Name;
import racing.util.Behavior;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RoundResultTest {

    String name;
    RacingCar racingCar;

    @BeforeEach
    void beforeEach() {
        this.name = "pobi";
        this.racingCar = new RacingCar(this.name);
    }

    @Test
    @DisplayName("레이싱 카 별 라운드 결과 객체 생성")
    void create() {
        assertThat(new RoundResult().getRoundResult()).isEmpty();
    }

    @Test
    @DisplayName("레이싱 카의 현재 라운드 결과 주입 - 전진")
    void record_FORWARD() {
        RoundResult roundResult = new RoundResult();
        roundResult.record(this.racingCar, 4);
        assertThat(roundResult.getRoundResult().get(this.racingCar.getName())).isEqualTo(Behavior.FORWARD.symbol);
    }

    @Test
    @DisplayName("레이싱 카의 현재 라운드 결과 주입 - 정지")
    void record_STOP() {
        RoundResult roundResult = new RoundResult();
        roundResult.record(this.racingCar, 3);
        assertThat(roundResult.getRoundResult().get(this.racingCar.getName())).isEqualTo(Behavior.STOP.symbol);
    }

    @Test
    @DisplayName("서로 다른 객체를 합쳤을 때, 동일한 속성 데이터 인지 확인")
    void record_2() {
        RoundResult firstRoundResult = new RoundResult();
        firstRoundResult.record(this.racingCar, 4);

        RoundResult lastRoundResult = new RoundResult();
        lastRoundResult.record(this.racingCar, 5);
        lastRoundResult.combined(firstRoundResult);

        assertAll(() -> assertThat(lastRoundResult.getRoundResult().keySet()).contains(this.racingCar.getName()),
                () -> assertThat(lastRoundResult.getRoundResult().get(this.racingCar.getName())).containsAnyOf(Behavior.FORWARD.symbol, Behavior.STOP.symbol));
    }

    @Test
    @DisplayName("우승자 찾기")
    void getWinners() {
        RoundResult roundResult = new RoundResult();
        roundResult.record(this.racingCar, 4);
        roundResult.record(new RacingCar("kitty"), 3);
        roundResult.record(new RacingCar("pika"), 3);

        List<Name> winners = roundResult.getWinners();
        assertThat(winners).hasSize(1);
        assertThat(winners.get(0)).isEqualTo(new Name(this.name));
    }
}