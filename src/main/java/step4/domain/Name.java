package step4.domain;

import step4.exception.NameExceedException;

import java.util.List;
import java.util.stream.Collectors;

public class Name {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    private Name(String name) {
        validate(name);

        this.name = name;
    }

    public static Name from(String name) {
        return new Name(name);
    }

    private void validate(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new NameExceedException("자동차 이름은 5글자를 초과할 수 없습니다. name: " + name);
        }
    }

    public String getName() {
        return name;
    }

    public static String parseWinnerNames(List<Name> names) {
        return names.stream()
                .map(Name::getName)
                .collect(Collectors.joining(","));
    }
}
