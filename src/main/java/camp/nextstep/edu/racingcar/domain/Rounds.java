package camp.nextstep.edu.racingcar.domain;

import camp.nextstep.edu.util.AssertUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
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

    public CarNames getWinnersOfLastRound() {
        return this.getLast()
                .map(Round::getWinners)
                .orElse(CarNames.emptyInstance());
    }

    // TODO: toString
    // TODO: equal
    // TODO: hashcode
}
