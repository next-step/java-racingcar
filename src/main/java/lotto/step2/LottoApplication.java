package lotto.step2;

import lotto.step2.domain.Lotto;
import lotto.step2.domain.LottoCount;
import lotto.step2.domain.Lottos;
import lotto.step2.domain.WinningNumbers;
import lotto.step2.enums.MatchNumber;
import lotto.step2.view.InputView;
import lotto.step2.view.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoCount lottoCount = inputView.inputInitData();
        Lotto lotto = new Lotto();
        Lottos lottos = new Lottos(lotto, lottoCount);
        resultView.printLottos(lottos);
        WinningNumbers winningNumbers = inputView.inputWinningNumbers();
        resultView.printWinnerStat(MatchNumber.getStatResult(winningNumbers.getWinnerStat(lottos)),
                MatchNumber.getTotalReturnResult(winningNumbers.getWinnerStat(lottos), lottoCount.getPrice()));
    }
}
