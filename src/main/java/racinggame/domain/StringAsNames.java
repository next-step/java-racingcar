package racinggame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringAsNames implements Names {
    private final String names;

    public StringAsNames(String names) {
        this.names = names;
    }

    @Override
    public List<Name> names() {
        String[] splitedNames = names.split(",");
        List<Name> names = new ArrayList<>();
        for (String splitedName : splitedNames) {
            names.add(new Name(splitedName));
        }
        return Collections.unmodifiableList(names);
    }
}
