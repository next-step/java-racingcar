package race.domain;

import java.util.List;
import java.util.Map;

public class RaceResult {
    private final List<String> winners;
    private final Map<Integer, List<String>> roundCarStateMessageMap;

    public RaceResult(List<String> winners, Map<Integer, List<String>> roundCarStateMessageMap) {
        this.winners = winners;
        this.roundCarStateMessageMap = roundCarStateMessageMap;
    }

    public List<String> winners() {
        return winners;
    }

    public Map<Integer, List<String>> roundCarStateMessageMap() {
        return roundCarStateMessageMap;
    }
}
