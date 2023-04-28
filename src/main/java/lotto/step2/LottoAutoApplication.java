package lotto.step2;

import lotto.step2.domain.*;
import lotto.step2.enums.MatchNumber;
import lotto.step2.view.InputView;
import lotto.step2.view.ResultView;

import java.util.Map;

public class LottoAutoApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        LottoCount lottoCount = inputView.inputInitData();
        LottoStrategy lottoStrategy = new LottoAutoStrategy();
        Lottos lottos = new Lottos(lottoStrategy, lottoCount);

        resultView.printLottos(lottos);

        WinningNumbers winningNumbers = inputView.inputWinningNumbers();
        Map<Integer, Long> statMap = winningNumbers.getWinnerStat(lottos);
        resultView.printWinnerStat(statMap, MatchNumber.getTotalReturnResult(statMap, lottoCount.getPrice()));
    }
}
