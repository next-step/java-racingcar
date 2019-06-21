package racinggame;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Winners {
    public static List<String> getWinner(Map<String, Integer> gameResult) {
        int maxPosition = getMaxPosition(gameResult);

        return gameResult.entrySet().stream()
                .filter((stringIntegerEntry -> stringIntegerEntry.getValue() == maxPosition))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private static int getMaxPosition(Map<String, Integer> gameResult) {
        int maxPosition = 0;
        for (Map.Entry<String, Integer> entry : gameResult.entrySet()) {
            maxPosition = Math.max(maxPosition, entry.getValue());
        }
        return maxPosition;
    }
}
