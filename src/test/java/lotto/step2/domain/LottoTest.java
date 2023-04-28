package lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @Test
    @DisplayName("로또 생성")
    void createLotto() {
        LottoStrategy lottoStrategy = new LottoAutoStrategy();
        Lotto lotto = new Lotto(lottoStrategy.createLotto().getLotto());
        assertThat(lotto.getLotto()).hasSize(6);
    }
}