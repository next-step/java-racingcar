package racingcar;

import java.util.List;

public record TurnResult(List<CarStatus> statuses) {

    public TurnResult {
        statuses = List.copyOf(statuses);
    }
}
