package racingcar.domain;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Names implements Iterable<Name> {
    private List<Name> names;

    public Names(List<String> names) {
        this.names = names.stream().map(Name::new).collect(Collectors.toList());
    }

    public Names() {
        this(Collections.emptyList());
    }

    @Override
    public Iterator<Name> iterator() {
        return names.iterator();
    }

    public int size() {
        return names.size();
    }

    public void clear() {
        names.clear();
    }

    public void add(Name name) {
        names.add(name);
    }
}
