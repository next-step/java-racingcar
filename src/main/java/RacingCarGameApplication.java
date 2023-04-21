import controller.RaceController;
import model.Race;
import model.RandomMoveStrategy;
import view.RaceView;

import java.util.Scanner;

public class RacingCarGameApplication {
    public static void main(String[] args) {
        var race = new Race();
        var scanner = new Scanner(System.in);
        var raceView = new RaceView(scanner);
        var randomStrategy = new RandomMoveStrategy();
        var raceController = new RaceController(race, raceView);
        raceController.startRace(randomStrategy);
    }
}
