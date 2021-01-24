package racingcar.view;

import java.util.List;
import racingcar.util.Constant;

public class ResultView {

    public void printWinner(List<String> winnerList) {
        System.out.print(Constant.FINAL_WINNER);
        System.out.println(String.join(", ", winnerList));
    }
}
