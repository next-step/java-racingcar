package race.domain;

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
        List<CarRaceGameHistory> lastRoundHistories = this.getLastRoundHistories();
        List<CarRaceGameHistory> winningHistories = this.getWinningRoundHistories(lastRoundHistories);

        return winningHistories.stream()
                .map(CarRaceGameHistory::getName)
                .collect(Collectors.toList());
    }

    private List<CarRaceGameHistory> getLastRoundHistories() {
        return this.roundHistories.get(this.roundHistories.size());
    }

    private List<CarRaceGameHistory> getWinningRoundHistories(List<CarRaceGameHistory> roundHistories) {

        return roundHistories.stream()
                .filter(history -> history.isSameStep(this.getMaxStep(roundHistories)))
                .collect(Collectors.toList());
    }

    private int getMaxStep(List<CarRaceGameHistory> roundHistories) {
        return roundHistories.stream()
                .mapToInt(CarRaceGameHistory::getStep)
                .max()
                .orElseThrow(NoSuchElementException::new);
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
