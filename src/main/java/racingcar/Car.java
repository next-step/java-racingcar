package racingcar;

import static java.util.stream.IntStream.range;

import java.util.stream.Collectors;

public class Car {

    private int position = 0;

    public void action(int num) {
        Command.of(num).accept(this);
    }

    public void forward() {
        this.position++;
    }

    public void nonForward() {
        // Non Forward
    }

    public String getLocation() {
        return range(0, position)
            .mapToObj(i -> "-")
            .collect(Collectors.joining(""));

    }
}
