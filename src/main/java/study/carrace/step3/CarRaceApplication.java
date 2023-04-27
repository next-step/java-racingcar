package study.carrace.step3;

import study.carrace.step3.application.RaceManager;
import study.carrace.step3.presentation.RaceMonitor;

import java.util.List;

import static study.carrace.step3.application.util.MoveStrategyFactory.randomMoveStrategy;
import static study.carrace.step3.presentation.util.ConsoleInputUtil.*;

public class CarRaceApplication {
    public static void main(String[] args) {
        List<String> carNames = askCarNames();
        int iterationCount = askIterationCount();

        RaceManager raceManager = new RaceManager(carNames, randomMoveStrategy(), iterationCount);
        RaceMonitor raceMonitor = new RaceMonitor(raceManager.startRace(), iterationCount);

        raceMonitor.showCarsPositionHistory();
        raceMonitor.announceWinners();
    }
}
