package game.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Name {
    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    public static List<Name> fromNames(String names) {
        String[] splitNames = names.split(",");
        return Arrays.stream(splitNames).map(Name::new).collect(Collectors.toList());
    }

    private void validateName(String name) {
        if (name == null || "".equals(name) || name.length() > 5) {
            throw new RuntimeException();
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
