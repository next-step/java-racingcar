package race;

import java.util.*;
import java.util.stream.Collectors;

public class CarRaceGameRoundHistories {
    private final Map<Integer, List<CarRaceGameHistory>> roundHistories;

    private CarRaceGameRoundHistories(Map<Integer, List<CarRaceGameHistory>> roundHistories) {
        this.roundHistories = roundHistories;
    }

    public static CarRaceGameRoundHistories create(Map<Integer, List<CarRaceGameHistory>> roundHistories) {
        return new CarRaceGameRoundHistories(roundHistories);
    }
    
    public Map<Integer, List<CarRaceGameHistory>> get() {
        Map<Integer, List<CarRaceGameHistory>> roundHistories = new HashMap<>();

        for (Map.Entry<Integer, List<CarRaceGameHistory>> histories : this.roundHistories.entrySet()) {
            roundHistories.put(histories.getKey(), histories.getValue()
                    .stream()
                    .map(CarRaceGameHistory::newInstance)
                    .collect(Collectors.toList()));
        }

        return roundHistories;
    }

    public List<String> selectWinners() {
        List<CarRaceGameHistory> lastRoundHistories = this.roundHistories.get(this.roundHistories.size());

        int maxStep = lastRoundHistories.stream()
                .mapToInt(CarRaceGameHistory::getStep)
                .max()
                .orElseThrow(NoSuchElementException::new);

        List<CarRaceGameHistory> winningHistories = lastRoundHistories.stream()
                .filter(history -> history.isSameStep(maxStep))
                .collect(Collectors.toList());

        return winningHistories.stream()
                .map(CarRaceGameHistory::getName)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarRaceGameRoundHistories that = (CarRaceGameRoundHistories) o;
        return Objects.equals(roundHistories, that.roundHistories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roundHistories);
    }
}
