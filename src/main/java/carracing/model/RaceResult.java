package carracing.model;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class RaceResult {
    private static final String WRONG_RACE_RESULT_GUIDE_MESSAGE = "잘못된 경기 결과입니다.";
    private static final String COMMA_SPACE_DELIMITER = ", ";
    private final List<RaceRecordOfCar> recordOfCarList;

    private RaceResult(final List<RaceRecordOfCar> recordOfCarList) {
        this.recordOfCarList = recordOfCarList;
    }

    public static RaceResult newResult(final List<RaceRecordOfCar> recordOfCarList) {
        return new RaceResult(recordOfCarList);
    }

    public List<RaceRecordOfCar> recordOfCarList() {
        return Collections.unmodifiableList(recordOfCarList);
    }

    public String winner() {
        int maxPosition = maxPositionOfCars();

        return recordOfCarList.stream()
                .filter(raceRecordOfCar -> raceRecordOfCar.samePosition(maxPosition))
                .map(RaceRecordOfCar::carName)
                .collect(Collectors.joining(COMMA_SPACE_DELIMITER));
    }

    private int maxPositionOfCars() {
        return recordOfCarList.stream()
                .mapToInt(RaceRecordOfCar::position)
                .max()
                .orElseThrow(() -> new NoSuchElementException(WRONG_RACE_RESULT_GUIDE_MESSAGE));
    }
}
