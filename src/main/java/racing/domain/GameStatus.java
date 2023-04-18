package racing.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GameStatus {
    private final Map<String, Integer> gameStatus;

    public GameStatus(List<Car> gameCars) {
        this.gameStatus = toGameStatus(gameCars);
    }

    private Map<String, Integer> toGameStatus(List<Car> gameCars) {
        Map<String, Integer> gameStatus = new LinkedHashMap<>();
        for (Car gameCar : gameCars) {
            gameStatus.put(gameCar.getNameString(), gameCar.getPositionInt());
        }
        return gameStatus;
    }

    public Set<String> getParticipants() {
        return gameStatus.keySet();
    }

    public int getPositionByName(String name) {
        return gameStatus.get(name);
    }
}