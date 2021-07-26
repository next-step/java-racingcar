package racing.view;

import racing.domain.game.dto.Turns;

public interface ResultView {
    void printResult(Turns turns);

    void printException(Exception e);
}
