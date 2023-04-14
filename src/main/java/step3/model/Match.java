package step3.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Match {

    private final List<Racer> collect;

    public Match(List<Car> participates, int iterations) {
        this.collect = IntStream.rangeClosed(1, participates.size())
                .boxed()
                .map(integer -> new Racer(iterations))
                .collect(Collectors.toList());
    }

    public List<List<String>> display() {
        return collect.stream()
                .map(Racer::getResults)
                .collect(Collectors.toList());
    }

    public List<String> winnerDisplay() {
        throw new RuntimeException();
    }
}
