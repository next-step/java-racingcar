package racingcar.step3_4.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Names {

    private final List<Name> names;

    private Names(List<Name> names) {
        this.names = names;
    }

    public static Names of(List<String> names) {
        return names.stream()
            .map(Name::new)
            .collect(Collectors.collectingAndThen(Collectors.toList(), Names::new));
    }

    public List<Name> getNames() {
        return List.copyOf(names);
    }

    public int getCount() {
        return names.size();
    }
}
