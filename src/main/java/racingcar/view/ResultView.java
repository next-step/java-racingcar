package racingcar.view;

import java.util.List;

public interface ResultView {
    void printStart();

    void printRoundResult(List<LaneViewModel> lanes);

    void printWinner(List<String> winnerNames);
}
