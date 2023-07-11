package racingcar.dto;

import java.util.List;

public class Results {
    private final List<Result> results;

    public Results(List<Result> results) {
        this.results = List.copyOf(results);
    }

    public List<Result> get() {
        return List.copyOf(results);
    }
}
