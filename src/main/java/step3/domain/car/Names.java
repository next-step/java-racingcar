package step3.domain.car;

import java.util.List;
import java.util.Objects;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static step3.utils.ValidationUtils.checkArgument;

public class Names {

    private static final String DELIMITER = ",";
    private static final int MIN_NAMES_SIZE = 1;

    private final List<Name> names;

    public static Names from(String stringNames) {
        checkArgument(stringNames != null, "stringNames is required");

        List<Name> names = stream(stringNames.split(DELIMITER))
                .map(Name::new)
                .collect(toList());
        return new Names(names);
    }

    public Names(List<Name> names) {
        checkNotEmpty(names);
        this.names = names;
    }

    private void checkNotEmpty(List<Name> names) {
        checkArgument(names != null && names.size() > MIN_NAMES_SIZE, "names is required");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Names names1 = (Names) o;
        return Objects.equals(names, names1.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names);
    }
}
