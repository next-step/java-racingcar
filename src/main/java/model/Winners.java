package model;

import java.util.Collections;
import java.util.List;

public class Winners {

    private final List<Name> names;

    public Winners(final List<Name> names) {
        this.names = names;
    }

    public List<Name> getNames() {
        return Collections.unmodifiableList(names);
    }
}
