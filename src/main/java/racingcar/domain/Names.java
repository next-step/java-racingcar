package racingcar.domain;

import racingcar.Name;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Names {

    private final List<Name> names;

    public Names(NameSeparator separator) {
        String[] names = separator.separate();

        this.names = new ArrayList<>();
        for (String name : names) {
            this.names.add(new Name(name));
        }
    }

    public List<Name> get() {
        return Collections.unmodifiableList(this.names);
    }

    public int size() { return names.size(); }

}
