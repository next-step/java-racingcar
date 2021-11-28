package carracing;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Rounds {
    private final List<Round> rounds = new LinkedList<>();

    public void add(Round round) {
        rounds.add(round);
    }

    public List<Round> getRounds() {
        return Collections.unmodifiableList(rounds);
    }

    public int getLongestStep() {
        Map<CarName, Integer> nameToStep = getLastRound().getSteps();
        int longestStep = nameToStep.values().stream()
                .mapToInt(i -> i)
                .max()
                .orElseThrow(() -> new IllegalStateException("Can't find winner."));
        return longestStep;
    }

    public List<CarName> getWinners() {
        Map<CarName, Integer> nameToStep = getLastRound().getSteps();
        int longestStep = getLongestStep();

        List<CarName> winnerNames = nameToStep.entrySet().stream()
                .filter(entry -> entry.getValue() == longestStep)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        return winnerNames;
    }

    private Round getLastRound() {
        return rounds.get(rounds.size() - 1);
    }
}
