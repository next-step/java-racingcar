package game;

import java.util.Collections;
import java.util.List;

public class GameResultDto {
    private final List<Integer> result;

    public GameResultDto(List<Integer> result) {
        this.result = result;
    }

    public List<Integer> getResult() {
        return Collections.unmodifiableList(result);
    }
}
