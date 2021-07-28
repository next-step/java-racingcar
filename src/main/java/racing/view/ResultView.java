package racing.view;

import racing.domain.dto.GameResponse;

public interface ResultView {
    void printResult(GameResponse response);

    void printException(Exception e);
}
