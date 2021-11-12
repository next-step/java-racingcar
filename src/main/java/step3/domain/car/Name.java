package step3.domain.car;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.lang.String.format;
import static java.util.stream.Collectors.toList;
import static step3.utils.ValidationUtils.checkArgument;

public class Name {

    private static final String DELIMITER = ",";
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    static final String NAME_LENGTH_ERROR_MESSAGE = format("이름은 %s자 이상 %s자 이하여야 합니다.", MIN_NAME_LENGTH, MAX_NAME_LENGTH);

    private final String name;

    public static List<Name> listOf(String stringNames) {
        checkArgument(stringNames != null, "stringNames is required");

        String[] names = stringNames.split(DELIMITER);
        return Arrays.stream(names)
                .map(Name::new)
                .collect(toList());
    }

    public Name(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name == null || name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Name{" +
                "name='" + name + '\'' +
                '}';
    }
}
