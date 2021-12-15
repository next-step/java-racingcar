package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarNames {

    private final List<RacingCarName> names;

    public RacingCarNames(String[] names) {
        this(Arrays.stream(names)
                .map(RacingCarName::new)
                .collect(Collectors.toList()));
    }

    public RacingCarNames(List<RacingCarName> names) {
        this.names = names;
    }

    public int size() {
        return names.size();
    }

    public RacingCarName get(int index) {
        return names.get(index);
    }

}
