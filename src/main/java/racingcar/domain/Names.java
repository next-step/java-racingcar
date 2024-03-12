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

    @Override
    public String toString() {
        return String.join(",", toStringArray());
    }

    private String[] toStringArray() {
        String[] stringArray = new String[names.size()];
        for (int i = 0; i < stringArray.length; i++) {
            stringArray[i] = names.get(i).get();
        }
        return stringArray;
    }
}
