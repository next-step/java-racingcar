package racingcar.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Winners {
    private final List<String> names;

    public Winners() {
        this.names = new ArrayList<>();
    }

    public Winners(List<String> winners) {
        this.names = winners;
    }

    public Stream<String> stream() {
        return names.stream();
    }

    public boolean sizeEqualTo(int size) {
        return names.size() == size;
    }

    public boolean contains(String name) {
        return names.contains(name);
    }
}
