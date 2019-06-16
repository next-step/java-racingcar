package camp.nextstep.edu.racingcar.domain;

import camp.nextstep.edu.util.AssertUtils;

import java.util.*;
import java.util.stream.Stream;

public class Rounds {

    private final List<Round> roundList;

    private Rounds(List<Round> roundList) {
        assert roundList != null;
        this.roundList = new ArrayList<>(roundList);
    }

    public static Rounds empty() {
        final List<Round> emptyRoundList = Collections.emptyList();
        return new Rounds(emptyRoundList);
    }

    public int size() {
        return roundList.size();
    }

    public void add(Round round) {
        AssertUtils.notNull(round, "'round' must not be null");
        roundList.add(round);
    }

    public Stream<Round> stream() {
        return roundList.stream();
    }

    public Optional<Round> getLast() {
        if (roundList.isEmpty()) {
            return Optional.empty();
        }
        final int size = roundList.size();
        final int lastIndex = size - 1;
        final Round round = roundList.get(lastIndex);
        return Optional.ofNullable(round);
    }

    @Override
    public String toString() {
        return "Rounds{" +
                "roundList=" + roundList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rounds rounds = (Rounds) o;
        return roundList.equals(rounds.roundList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roundList);
    }
}
