package study.carrace.step3.presentation.util;

import study.carrace.step3.application.dto.RaceFinishedCar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RaceResultFactory {
    private static final String LINE_BREAK = "\n";
    private static final String COLON = ":";
    private static final String POSITION_CURSOR = "-";

    private RaceResultFactory() {
    }

    public static String carNamesAndPositionsAt(List<RaceFinishedCar> raceFinishedCars, int iteration) {
        StringBuilder carNamesAndPositions = new StringBuilder();
        raceFinishedCars.forEach(raceFinishedCar -> {
            carNamesAndPositions.append(carNameAndPositionAt(raceFinishedCar, iteration));
        });

        return carNamesAndPositions.toString();
    }

    public static List<String> firstRankers(List<RaceFinishedCar> raceFinishedCars) {
        return findCarNamesBy(raceFinishedCars, maxNumberOfMove(raceFinishedCars));
    }

    private static List<String> findCarNamesBy(List<RaceFinishedCar> raceFinishedCars, int numberOfMove) {
        return raceFinishedCars.stream()
                .filter(raceFinishedCar -> numberOfMove(raceFinishedCar) == numberOfMove)
                .map(RaceFinishedCar::getName)
                .collect(Collectors.toList());
    }

    private static int maxNumberOfMove(List<RaceFinishedCar> raceFinishedCars) {
        return raceFinishedCars.stream()
                .map(RaceResultFactory::numberOfMove)
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
    }

    private static int numberOfMove(RaceFinishedCar raceFinishedCar) {
        return raceFinishedCar.getMoveStatuses()
                .stream()
                .filter(b -> b)
                .mapToInt(b -> 1)
                .sum();
    }

    private static String carNameAndPositionAt(RaceFinishedCar raceFinishedCar, int iteration) {
        return new StringBuilder()
                .append(raceFinishedCar.getName())
                .append(COLON)
                .append(positionAt(raceFinishedCar, iteration))
                .append(LINE_BREAK)
                .toString();
    }

    private static String positionAt(RaceFinishedCar raceFinishedCar, int iteration) {
        int count = IntStream.range(0, iteration)
                .filter(i -> raceFinishedCar.getMoveStatuses().get(i))
                .map(i -> 1)
                .sum();

        return POSITION_CURSOR.repeat(count);
    }
}
