package step4.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Names {

    private final List<Name> names = new ArrayList<>();

    public void addNames(String namesStr) {
        String[] nameList = namesStr.split(",");

        Arrays.stream(nameList).forEach(nameStr -> {
            Name name = new Name(nameStr);
            names.add(name);
        });
    }

    public void addNames(List<Name> nameList) {
        names.addAll(nameList);
    }

    public List<Name> getNames() {
        return names;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Names names1 = (Names) o;
        return Objects.equals(names, names1.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names);
    }
}
