package racingcar.service.dto;

import java.util.List;
import java.util.Objects;

public class GameResult {
    List<RacingCarRecord> result;

    public List<RacingCarRecord> getResult() {
        return result;
    }

    public GameResult(List<RacingCarRecord> result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        GameResult that = (GameResult) object;
        return Objects.equals(getResult(), that.getResult());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getResult());
    }
}
