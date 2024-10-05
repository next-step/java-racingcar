package race;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

public class CarRaceGameHistory {
    private final int round;
    private final int step;
    private final String name;

    private CarRaceGameHistory(int round, int step, String name) {
        this.round = round;
        this.step = step;
        this.name = name;
    }

    public int getStep() {
        return this.step;
    }

    public int getRound() {
        return this.round;
    }

    public String getName() {
        return this.name;
    }

    public static CarRaceGameHistory record(int round, int step, String name) {
        return new CarRaceGameHistory(round, step, name);
    }

    public static List<CarRaceGameHistory> selectWinningHistories(List<CarRaceGameHistory> histories) {
        if (isNotSameRound(histories)) {
            throw new IllegalArgumentException("같은 라운드의 게임 기록이 아닙니다.");
        }

        int maxStep =
                histories.stream().mapToInt(CarRaceGameHistory::getStep).max().orElseThrow(NoSuchElementException::new);

        return histories.stream().filter(history -> history.step == maxStep).collect(Collectors.toList());
    }

    private static boolean isNotSameRound(List<CarRaceGameHistory> histories) {
        return histories.stream().anyMatch(history -> history.round != histories.get(0).round);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarRaceGameHistory history = (CarRaceGameHistory) o;
        return round == history.round && step == history.step && Objects.equals(name, history.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(round, step, name);
    }
}
