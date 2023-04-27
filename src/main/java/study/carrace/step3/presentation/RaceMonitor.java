package study.carrace.step3.presentation;

import study.carrace.step3.application.dto.RaceFinishedCar;
import study.carrace.step3.presentation.util.RaceResultFactory;

import java.util.List;
import java.util.stream.IntStream;

import static study.carrace.step3.presentation.PromptMessage.*;

public class RaceMonitor {
    private final List<RaceFinishedCar> raceFinishedCars;
    private final int iterationCount;

    public RaceMonitor(List<RaceFinishedCar> raceFinishedCars, int iterationCount) {
        this.raceFinishedCars = raceFinishedCars;
        this.iterationCount = iterationCount;
    }

    public void showCarsPositionHistory() {
        announceRaceResult();
        IntStream.rangeClosed(1, iterationCount)
                        .forEach(i -> System.out.println(RaceResultFactory.carNamesAndPositionsAt(raceFinishedCars, i)));
    }

    public void announceWinners() {
        System.out.println(RaceResultFactory.firstRankers(raceFinishedCars) + WINNER_ANNOUNCE_MESSAGE.getMessage());
    }

    private void announceRaceResult() {
        System.out.println(RACE_RESULT_ANNOUNCE_MESSAGE.getMessage());
    }
}
