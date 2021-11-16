package racingcar.domain;

import java.util.*;

public class Winners {
    private final List<String> names;

    public Winners() {
        this.names = new ArrayList<>();
    }

    public Winners(List<String> winners) {
        this.names = winners;
    }

    public boolean sizeEqualTo(int size) {
        return names.size() == size;
    }

    public boolean contains(String name) {
        return names.contains(name);
    }

    public String provideWinnerNames() {
        return names.stream().reduce((accumulator, winner) ->
                accumulator + ", " + winner
        ).orElseThrow(() ->
                new NoSuchElementException("There is no Winner!")
        );
    }
}
