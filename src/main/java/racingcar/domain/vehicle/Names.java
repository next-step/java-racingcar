package racingcar.domain.vehicle;

import java.util.List;
import java.util.stream.Collectors;

public class Names {

    private final List<Name> names;

    public Names(List<Name> names) {
        this.names = names;
    }

    @Override
    public String toString() {
        return names.stream().map(Name::toString).collect(Collectors.joining(","));
    }
}
