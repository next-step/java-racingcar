package step3.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Match {

    private final List<Racer> collect;
    public Match(int participates, int iterations) {
        this.collect = IntStream.rangeClosed(1, participates).boxed().map(integer -> new Racer(iterations)).collect(Collectors.toList());
    }

    public List<List<String>> display() {
        return collect.stream().map(racer -> racer.getRaceResults()).collect(Collectors.toList());
    }
}
