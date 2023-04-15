package step3.model;

import step3.present.DisplayRaceVO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Match {

    private final List<Racer> racerList;

    public Match(List<Car> participates, int iterations) {
        this.racerList = IntStream.range(0, participates.size())
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
        //전체 점수를 가져온데
        List<Integer> positions = new ArrayList<>();
        for(Racer racer : racerList) {
            positions.add(racer.getFinalPosition());
        }

        //최고득점을 가져온다
        int maxPos = positions.stream().mapToInt(pos -> pos.intValue()).max().getAsInt();
        //최고득점인 사람을 찾는다
        List<String> collect1 = racerList.stream().filter(racer -> racer.getFinalPosition() == maxPos).map(racer -> racer.getCar().getName()).collect(Collectors.toList());
        return collect1;
    }

}
