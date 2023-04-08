package carracing;

import carracing.race.RaceApplication;
import carracing.race.ui.InputView;
import carracing.race.ui.ResultView;

public class Launcher {
    public static void main(String[] args) {
        RaceApplication raceApplication = new RaceApplication(new InputView(System.in,System.out),new ResultView(System.out));
        raceApplication.run();
    }
}
