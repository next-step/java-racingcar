package carracing.rounds;

import carracing.cars.CarName;

import java.util.*;
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
        return max(nameToStep.values());
    }

    public List<CarName> getWinners() {
        Map<CarName, Integer> nameToStep = getLastRound().getSteps();
        int longestStep = getLongestStep();

        return nameToStep.entrySet().stream()
                .filter(entry -> entry.getValue() == longestStep)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private Round getLastRound() {
        return rounds.get(rounds.size() - 1);
    }

    private int max(Collection<Integer> collection) {
        return collection.stream()
                .mapToInt(i -> i)
                .max()
                .orElseThrow(() -> new IllegalStateException("Can't find max."));
    }
}
