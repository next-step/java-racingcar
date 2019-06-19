package racingcar.view.result;

import java.util.List;

public interface ResultView {
    void printHeader();
    void printBody(List<Integer> carPositions);
    void printFooter();
}
