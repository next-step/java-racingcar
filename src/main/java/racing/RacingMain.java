package racing;

import racing.domain.RacingSimulator;
import racing.domain.Round;
import racing.utils.StringUtil;
import racing.views.IntegerInputView;
import racing.views.RoundView;
import racing.views.StringInputView;
import racing.views.WinnersView;

public class RacingMain {
    public static void main(String[] args) {
        final String namesInput = new StringInputView().show("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        final int attemptsCount = new IntegerInputView().show("시도할 횟수는 몇 회인가요?");

        final RacingSimulator simulator = new RacingSimulator(StringUtil.splitCommas(namesInput), attemptsCount);
        simulator.start();

        System.out.println("\n실행 결과");
        final RoundView roundView = new RoundView();
        for (final Round round : simulator.getRounds()) {
            roundView.show(round);
            System.out.println();
        }

        new WinnersView().show(simulator.getWinnerList());
    }
}
