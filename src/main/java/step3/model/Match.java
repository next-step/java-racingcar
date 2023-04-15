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
        int maxPosition = getMaxPosition();
        List<String> winnerList = getWinnerList(maxPosition);
        return winnerList;
    }

    private List<String> getWinnerList(int maxPosition) {
        List<String> list = new ArrayList<>();
        for(Racer racer : racerList) {
            if(racer.getFinalPosition()== maxPosition) {
                list.add(racer.getCar().getName());
            }
        }
        return list;
    }

    private int getMaxPosition() {
        int max = -1;
        for(Racer racer : racerList) {
            max = Math.max(max, racer.getFinalPosition());
        }
        return max;
    }

}
