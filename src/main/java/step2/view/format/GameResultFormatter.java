package step2.view.format;

import step2.domain.GameResult;

public interface GameResultFormatter<T> {
    T format(final GameResult gameResult);
}
