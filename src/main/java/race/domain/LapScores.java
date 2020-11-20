package race.domain;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LapScores {
    private final List<LapScore> lapScores;

    public LapScores(List<LapScore> lapScores) {
        this.lapScores = lapScores;
    }

    public void forEach(Consumer<? super LapScore> action) {
        lapScores.forEach(action);
    }

    public <R> Stream<R> map(Function<? super LapScore, ? extends R> function) {
        return lapScores.stream().map(function);
    }

    public LapScores getFrontLine() {
        int maxPosition = lapScores.stream()
                .mapToInt(LapScore::getPosition)
                .max()
                .getAsInt();
        return new LapScores(lapScores.stream()
                .filter(score -> score.getPosition() == maxPosition)
                .collect(Collectors.toUnmodifiableList()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LapScores that = (LapScores) o;
        return Objects.equals(lapScores, that.lapScores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lapScores);
    }
}
