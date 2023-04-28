package lotto.step2.enums;

import lotto.step2.domain.Lottos;
import lotto.step2.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.step2.domain.Fixture.lottosList;
import static lotto.step2.domain.Fixture.winningNumber;
import static org.assertj.core.api.Assertions.assertThat;

class MatchNumberTest {
    @Test
    @DisplayName("총 수익률 검증(3000원 구입했을 때, 6개 일치 - 1개, 3개 일치 - 2개)")
    void getTotalReturnResult() {
        WinningNumbers winningNumbers = new WinningNumbers(winningNumber);
        Lottos lottos = new Lottos(lottosList);
        double amount = MatchNumber.getTotalReturnResult(winningNumbers.getWinnerStat(lottos), 3000).getTotalReturn();
        assertThat(amount).isEqualTo(66670.0);
    }
}