package study.carrace.step3;

import study.carrace.step3.application.RaceManager;
import study.carrace.step3.presentation.RaceMonitor;

import static study.carrace.step3.application.util.MoveStrategyGenerator.*;
import static study.carrace.step3.presentation.util.ConsoleInputUtil.*;

public class CarRaceApplication {
    public static void main(String[] args) {
        RaceManager raceManager = new RaceManager(askCarNames(), randomMoveStrategy());
        RaceMonitor raceMonitor = new RaceMonitor(raceManager);

        startRace(raceMonitor, raceManager, askIterationCount());
        announceWinners(raceMonitor);
    }

    private static void announceWinners(RaceMonitor raceMonitor) {
        raceMonitor.announceWinners();
    }

    private static void startRace(RaceMonitor raceMonitor, RaceManager raceManager, long iterationCount) {
        raceMonitor.announceRaceResult();
        for (int i = 0; i < iterationCount; i++) {
            raceManager.moveOrStopCars();
            raceMonitor.showCarsPosition();
        }
    }
}
