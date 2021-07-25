package racingcar.domain;

import java.util.List;

public class Winners {

    private List<Name> names;

    private Winners(List<Name> names) {
        this.names = names;
    }

    public static Winners valueOf(List<Name> names) {
        return new Winners(names);
    }

    @Override
    public String toString() {
        return names.toString();
    }
}
