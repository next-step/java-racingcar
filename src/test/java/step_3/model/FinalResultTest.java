package step_3.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step_3.util.Behavior;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class FinalResultTest {

    RoundResult roundResult;

    @BeforeEach
    void beforeEach() {
        this.roundResult = new RoundResult();
        roundResult.record(UUID.randomUUID().toString(), Behavior.FORWARD);
    }

    @Test
    @DisplayName("게임 결과 Model 생성")
    void create() {
        assertThat(new FinalResult().getRoundResults()).isEmpty();
    }

    @Test
    @DisplayName("라운드 결과 주입")
    void record_1() {
        FinalResult finalResult = new FinalResult();
        finalResult.record(this.roundResult);
        assertThat(finalResult.getRoundResults()).hasSize(1);
    }

    @Test
    @DisplayName("서로 다른 객체를 합쳤을 때, 동일한 속성 데이터 인지 확인")
    void record_2() {
        FinalResult firstFinalResult = new FinalResult();
        firstFinalResult.record(this.roundResult);

        FinalResult lastFinalResult = new FinalResult();
        lastFinalResult.record(firstFinalResult);

        assertThat(lastFinalResult.getRoundResults().get(0)).isSameAs(firstFinalResult.getRoundResults().get(0));
    }
}