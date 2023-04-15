package step3.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Match {

    private final List<Racer> collect;

    public Match(List<Car> participates, int iterations) {
        this.collect = IntStream.range(0, participates.size())
                .boxed()
                .map(integer -> new Racer(iterations,participates.get(integer)))
                .collect(Collectors.toList());
    }

    public List<List<String>> display() {
        return collect.stream()
                .map(Racer::getResults)
                .collect(Collectors.toList());
    }

    public List<String> winnerDisplay() {
        //전체 점수를 가져온데
        List<Integer> positions = collect.stream().map(racer -> racer.getFinalPosition()).collect(Collectors.toList());
        //최고득점을 가져온다
        int maxPos = positions.stream().mapToInt(pos -> pos.intValue()).max().getAsInt();
        //최고득점인 사람을 찾는다
        List<String> collect1 = collect.stream().filter(racer -> racer.getFinalPosition() == maxPos).map(racer -> racer.getCar().getName()).collect(Collectors.toList());
        return collect1;
    }

}
