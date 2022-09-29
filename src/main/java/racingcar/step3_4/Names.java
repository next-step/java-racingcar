package racingcar.step3_4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Names {

    private final List<Name> names;

    private Names(List<Name> names) {
        this.names = names;
    }

    public static Names of(String[] names) {
        return new Names(toList(names));
    }

    private static List<Name> toList(String[] names) {
        return Arrays.stream(names)
            .map(Name::new)
            .collect(Collectors.toList());
    }

    public List<Name> getNames() {
        return List.copyOf(names);
    }

    public int getCount() {
        return names.size();
    }
}
