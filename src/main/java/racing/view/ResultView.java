package racing.view;

import racing.domain.turn.Turns;

public interface ResultView {
    void printResult(Turns turns);

    void printException(Exception e);
}
