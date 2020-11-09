package step3;

import java.util.List;

public class ResultView {

    private RaceDisplay raceDisplay = RaceDisplay.console();

    public void showRaceState(List<Car> cars){
        cars.forEach( car -> car.displayOn(raceDisplay));
        raceDisplay.writeBlankLine();
    }

}
