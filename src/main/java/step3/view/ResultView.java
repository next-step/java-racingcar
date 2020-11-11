package step3.view;

import step3.domain.CarState;
import step3.domain.JoinedCars;
import step3.domain.RaceDisplay;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private RaceDisplay raceDisplay = RaceDisplay.console();

    public void showRaceState(JoinedCars joinedCars){
        joinedCars.displayRaceStateOn(raceDisplay);
    }

    public void showRaceWinner(List<CarState> winners){
        String winnerNames = winners.stream()
                .map(it -> it.getName()).collect(Collectors.joining(","));
        raceDisplay.writeLine(winnerNames +"가 최종 우승했습니다.");
    }
}
