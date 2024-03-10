package model;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private static final String WINNER_SEPARATOR = ", ";

    private final List<Name> names;

    public Winners(final List<Name> names) {
        this.names = names;
    }

    public String concatenateNames() {
        return names.stream()
                .map(Name::getName)
                .collect(Collectors.joining(WINNER_SEPARATOR));
    }

    public List<Name> getNames() {
        return names;
    }
}
