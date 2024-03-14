package racingcar.domain;

import java.util.List;

public class Winners {

    private final Names names;

    public Winners(Names names) {
        this.names = names;
    }

    public Names get() {
        return this.names;
    }

    public List<Name> getNames() {
        return this.names.get();
    }

}
