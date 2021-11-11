package racingcar;

public interface OutputView {
    void showOutputMessage();
    void showStartOfRound(int round);
    void showEndOfRound(int round);
    void showRacing(Cars cars);
    void showWinners(Cars winners);
}
