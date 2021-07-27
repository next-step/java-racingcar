package racing.view;

import racing.domain.Turn;

public interface ResultView {
    void printResultTitle();

    void printTurn(Turn turn);

    void printWinners(Turn turn);

    void printException(Exception e);
}
