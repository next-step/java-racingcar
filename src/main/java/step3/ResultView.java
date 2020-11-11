package step3;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private RaceDisplay raceDisplay = RaceDisplay.console();

    public void showRaceState(List<Car> cars){
        cars.forEach( car -> car.displayOn(raceDisplay));
        raceDisplay.writeBlankLine();
    }

    public void showRaceWinner(List<Car> winners){
        raceDisplay.writeRaceWinner(winners.stream().map(it -> it.getName()).collect(Collectors.toList()));
    }

}
