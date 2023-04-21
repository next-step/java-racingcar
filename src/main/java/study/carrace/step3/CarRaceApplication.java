package study.carrace.step3;

import study.carrace.step3.application.RaceManager;
import study.carrace.step3.presentation.RaceMonitor;

import static study.carrace.step3.application.util.MoveStrategyFactory.randomMoveStrategy;
import static study.carrace.step3.presentation.util.ConsoleInputUtil.*;

public class CarRaceApplication {
    public static void main(String[] args) {
        RaceManager raceManager = new RaceManager(askCarNames(), randomMoveStrategy(), askIterationCount());
        RaceMonitor raceMonitor = new RaceMonitor(raceManager);

        raceManager.startRace();

        raceMonitor.showCarsPositionHistory();
        raceMonitor.announceWinners();
    }
}
