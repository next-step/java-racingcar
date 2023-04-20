package domain.game;

import java.util.Collections;
import java.util.List;

public class GameResultDto {
    private final List<CarDto> result;

    public GameResultDto(List<CarDto> result) {
        this.result = result;
    }

    public List<CarDto> getResult() {
        return Collections.unmodifiableList(result);
    }
}
