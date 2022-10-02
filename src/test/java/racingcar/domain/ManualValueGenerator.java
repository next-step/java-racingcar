package racingcar.domain;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ManualValueGenerator implements Generator {

    private final Queue<Integer> values;

    public ManualValueGenerator(Integer... values) {
        this.values = new LinkedList<>(Arrays.asList(values));
    }

    public int nextValue() {
        return values.poll();
    }

    public boolean hasNext() {
        return values.isEmpty();
    }
}
