package lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {
    @Test
    @DisplayName("로또 생성")
    void createLotto() {
        Lotto lotto = new Lotto();
        assertThat(lotto.createLotto()).hasSize(6);
    }
}