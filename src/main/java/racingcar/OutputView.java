package racingcar;

import java.util.List;

public interface OutputView {
    void showOutput(List<Car> cars);
    void showOutputMessage();
    void showRound(int round);
}
