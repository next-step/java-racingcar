package racingcar.dto;

import java.util.Objects;
import racingcar.domain.NumberOfAttempts;

public class GameResultInfo {

    private final String gameResult;
    private final NumberOfAttempts leftNumberOfAttempts;

    public GameResultInfo(String gameResult, NumberOfAttempts leftNumberOfAttempts) {
        this.gameResult = gameResult;
        this.leftNumberOfAttempts = leftNumberOfAttempts;
    }

    public String getGameResult() {
        return gameResult;
    }

    public NumberOfAttempts getLeftNumberOfAttempts() {
        return leftNumberOfAttempts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GameResultInfo that = (GameResultInfo) o;
        return Objects.equals(gameResult, that.gameResult) && Objects.equals(leftNumberOfAttempts,
                that.leftNumberOfAttempts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameResult, leftNumberOfAttempts);
    }
}
