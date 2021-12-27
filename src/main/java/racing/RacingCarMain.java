package racing;

import java.util.List;
import racing.domain.Racing;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingCarMain {

    public static void main(String[] args) {

        List<String> names = InputView.inputCarNames();
        int totalRound = InputView.inputTotalRound();

        Racing racing = new Racing(names);

        System.out.println("실행결과");
        for (int i = 0; i < totalRound; i++) {
            ResultView.printRoundResult(racing.roundStart());
            System.out.println();
        }
        ResultView.printWinner(racing.winners());

    }

}
