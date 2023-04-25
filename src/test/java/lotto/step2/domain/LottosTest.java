package lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottosTest {
    @Test
    @DisplayName("구매 금액에 따른 로또 구매 목록 생성(10000원 => 10개)")
    void createLottos() {
        Lottos lottos = new Lottos(new Lotto(), new LottoCount(10000));
        assertThat(lottos.getLottos().size()).isEqualTo(10);
    }
}