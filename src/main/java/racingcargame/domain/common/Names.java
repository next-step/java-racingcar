package racingcargame.domain.common;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Names {

    private final List<Name> names;

    public Names(List<Name> names) {
        this.names = names.stream()
            .map(name -> new Name(name.getValue()))
            .collect(Collectors.toList());
    }

    public Names(String names, String delimiter) {
        this.names = Arrays.stream(names.split(delimiter))
            .map(Name::new)
            .collect(Collectors.toList());
    }

    public List<Name> getNames() {
        return Collections.unmodifiableList(names);
    }
}
