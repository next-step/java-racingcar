package racinggame.dto;

import java.util.ArrayList;
import java.util.List;

public class RacingInputDTO {
    private final List<String> carNames;
    private final int gameCount;

    public RacingInputDTO(List<String> carNames, int gameCount) {
        this.carNames = new ArrayList<>(carNames);
        this.gameCount = gameCount;
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getGameCount() {
        return gameCount;
    }
}
