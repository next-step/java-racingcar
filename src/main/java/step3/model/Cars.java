package step3.model;

import step3.view.output.OutputText;
import step3.view.output.RaceRecorder;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Cars {

    private static final String DIAMETER = ",";
    private static final int NAME_LENGTH_LIMIT = 5;
    private List<Car> cars;
    private RaceRecorder raceRecorder;

    public Cars(String players) {
        setPlayerNameForEachCar(players.split(DIAMETER));
        this.raceRecorder = new RaceRecorder();
    }

    private void setPlayerNameForEachCar(String[] playerNames) {
        checkNameLength(playerNames);

        this.cars = Arrays.stream(playerNames)
                .filter(s -> s.length() < NAME_LENGTH_LIMIT)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void runRace() {
        this.cars.forEach(car -> {
            car.makeCarMove();
            raceRecorder.saveRacingRecord(car);
        });
        raceRecorder.appendNewLine();
    }

    public void sortWinners() {
        String result = this.cars.stream()
                            .collect(Collectors.groupingBy(
                                    Car::getCarMovedCount,
                                    TreeMap::new,
                                    Collectors.toList()
                            ))
                            .lastEntry()
                            .getValue()
                            .stream()
                            .map(Car::getCarName)
                            .collect(Collectors.joining(DIAMETER));

        raceRecorder.saveWinners(result);
    }

    public String getGameResult() {
        return this.raceRecorder.getResultString();
    }

    private void checkNameLength(String[] playerNames) {
        try {
            Arrays.stream(playerNames)
                    .filter(s -> s.length() > NAME_LENGTH_LIMIT)
                    .findFirst()
                    .ifPresent(NumberFormatException::new);
        } catch (Exception e) {
            raceRecorder.appendError(OutputText.LENGTH_ERROR);
        }
    }
}
