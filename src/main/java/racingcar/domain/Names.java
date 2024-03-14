package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Names {

    private List<Name> names;

    public Names() {
        this.names = new ArrayList<>();
    }

    public void add(Name name) {
        this.names.add(name);
    }

    public List<Name> get() {
        return Collections.unmodifiableList(this.names);
    }

    public int size() {
        return this.names.size();
    }

}
