package step_3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step_3.util.Behavior;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RoundResultTest {

    private final String id = UUID.randomUUID().toString();

    @Test
    @DisplayName("레이싱 카 별 라운드 결과 객체 생성")
    void create() {
        assertThat(new RoundResult().getBehaviorByRacingCarId()).isEmpty();
    }

    @Test
    @DisplayName("레이싱 카의 현재 라운드 결과 주입")
    void record_1() {
        RoundResult roundResult = new RoundResult();
        roundResult.record(this.id, Behavior.FORWARD);
        assertThat(roundResult.getBehavior(this.id)).isEqualTo(Behavior.FORWARD);
    }

    @Test
    @DisplayName("서로 다른 객체를 합쳤을 때, 동일한 속성 데이터 인지 확인")
    void record_2() {
        RoundResult firstRoundResult = new RoundResult();
        firstRoundResult.record(this.id, Behavior.FORWARD);

        RoundResult lastRoundResult = new RoundResult();
        lastRoundResult.record(firstRoundResult);

        assertAll(() -> assertThat(lastRoundResult.getBehaviorByRacingCarId().keySet()).contains(this.id),
                () -> assertThat(lastRoundResult.getBehavior(id)).isEqualTo(Behavior.FORWARD));
    }
}