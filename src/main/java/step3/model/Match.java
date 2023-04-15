package step3.model;

import step3.present.DisplayRaceVO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Match {

    private final List<Racer> racerList;
    private final List<Racer> winnerList;

    public Match(List<Car> participates, int iterations) {
        this.racerList = makeRacers(participates, iterations);
        this.winnerList = getWinnerList();
    }

    private static List<Racer> makeRacers(List<Car> participates, int iterations) {
        return IntStream.range(0, participates.size())
            .boxed()
            .map(integer -> new Racer(iterations, participates.get(integer)))
            .collect(Collectors.toList());
    }

    public List<DisplayRaceVO> display() {
        return racerList.stream()
            .map(racer -> new DisplayRaceVO(new Result(racer.getResults()), racer.getCar()))
            .collect(Collectors.toList());
    }

    public List<String> winnerDisplay() {
        return new ArrayList<>(winnerList).stream()
            .map(racer -> racer.getCar().getName())
            .collect(Collectors.toList());
    }

    private List<Racer> getWinnerList( ) {
        return racerList.stream()
            .filter(racer -> racer.isSamePosition(getMaxPosition()))
            .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return racerList.stream()
            .mapToInt(Racer::getFinalPosition)
            .max()
            .orElseThrow(() -> new RuntimeException("최대값을 구할 수 없습니팅"));
    }
}
