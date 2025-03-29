package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.domain.TrialCoin;

public class TrialCoinTest {

    @Test
    void 트라이얼_코인_생성_테스트() {
        TrialCoin trialCoin = new TrialCoin(3);
        assertThat(trialCoin.isCoinLeft()).isTrue();
    }

    @Test
    void 트라이얼_코인_감소_테스트() {
        TrialCoin trialCoin = new TrialCoin(2);
        trialCoin.decrease();
        assertThat(trialCoin.isCoinLeft()).isTrue();
        trialCoin.decrease();
        assertThat(trialCoin.isCoinLeft()).isFalse();
    }

    @Test
    void 음수_트라이얼_코인_예외_테스트() {
        assertThatThrownBy(() -> new TrialCoin(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도횟수는 음수이면 안됩니다");
    }
}
