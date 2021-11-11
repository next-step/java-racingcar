package edu.nextstep.camp;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Winners {
    private final Collection<Name> winners;

    public static Winners of(Stream<Name> winners) {
        return new Winners(winners.collect(Collectors.toList()));
    }

    public static Winners of(Collection<Name> winners) {
        return new Winners(winners);
    }

    private Winners(Collection<Name> winners) {
        this.winners = Collections.unmodifiableCollection(winners);
    }

    public Stream<Name> stream() {
        return winners.stream();
    }
}
