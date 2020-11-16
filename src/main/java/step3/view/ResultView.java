package step3.view;

import step3.domain.RaceDisplay;
import step3.domain.RaceResult;
import step3.domain.RaceState;

public class ResultView {

    private RaceDisplay raceDisplay = RaceDisplay.console();

    public void showRaceState(RaceState raceState){
        raceState.displayOn(raceDisplay);
    }

    public void showRaceResult(RaceResult raceResult){
        raceResult.displayOn(raceDisplay);
    }

}
