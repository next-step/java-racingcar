package step3.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RaceResult implements Displayable {

    private List<CarState> winnerStates;

    public RaceResult(List<Car> winners) {
        this.winnerStates = winners.stream().map(it -> CarState.of(it)).collect(Collectors.toList());
    }

    @Override
    public void displayOn(RaceDisplay raceDisplay) {
        String winnerNames = winnerStates.stream().map(CarState::getName).collect(Collectors.joining(","));
        raceDisplay.writeLine(winnerNames +"가 최종 우승했습니다.");
    }
}
