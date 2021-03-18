package racing;

import racing.domain.RacingSimulator;
import racing.domain.Round;
import racing.utils.StringUtil;
import racing.views.InputView;
import racing.views.ResultView;

public class RacingMain {
    public static void main(String[] args) {
        final String namesInput = InputView.carNames();
        final int attemptsCount = InputView.attemptsCount();

        final RacingSimulator simulator = new RacingSimulator(StringUtil.splitCommas(namesInput), attemptsCount);
        simulator.start();

        System.out.println("\n실행 결과");
        for (final Round round : simulator.getRounds()) {
            ResultView.show(round);
            System.out.println();
        }

        ResultView.show(simulator.getWinnerList());
    }
}
