package step3;

import java.util.List;
import java.util.stream.Collectors;

public class MatchResult {

    private List<Car> winners;

    public MatchResult(List<Car> winners) {
        this.winners = winners;
    }

    public List<Car> getWinners() {
        return winners;
    }

    public void print() {
        System.out.println(winners
                .stream().map(Car::getName)
                .collect(Collectors.joining(",")) + "가 최종 우승했습니다");
    }
}
