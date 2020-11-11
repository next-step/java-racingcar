package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.CarRacing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RaceRoundTest {

    private CarRacing carRacing;

    @BeforeEach
    void setUp() {
        this.carRacing = new CarRacing("next,step,yoon",10);
        this.carRacing.start();
    }

    @Test
    @DisplayName("CarRacing 객체에서 레이싱이 끝나고 저장된 랩 수 확인")
    void 레이스_기록에_저장된_마지막랩_검증() {
        RaceRound raceRound = carRacing.getRaceRound();
        assertThat(raceRound.getRoundCount()).isEqualTo(10);
    }

    @Test
    @DisplayName("CarRacing 객체에 설정된 랩 수 보다 초과된 랩수 를 조회할 경우 IndexOutOfBoundsException 발생")
    void 레이스_기록에_초과된_랩수로_결과를_조회() {
        RaceRound raceRound = carRacing.getRaceRound();
        assertThatThrownBy(() ->
            raceRound.findResult(11)
        ).isInstanceOf(IndexOutOfBoundsException.class);
    }

}
