package car_racing.domain.model;

import java.util.ArrayList;
import java.util.List;

public class RaceResults {
    private static final String RACE_RESULT_DELIMITER = " : ";

    private final List<Car> cars;

    public RaceResults(List<Car> cars) {
        this.cars = cars;
    }

    public List<String> getRaceResultOfNthRound(int n) {
        List<String> result = new ArrayList<>();
        for (Car car : cars) {
            result.add(getRaceResultOfNthRoundOfEachCar(n, car));
        }
        return result;
    }

    private String getRaceResultOfNthRoundOfEachCar(int n, Car car) {
        RaceResult raceResult = car.getRaceResult();

        StringBuilder sb = new StringBuilder();
        sb.append(car.getName())
                .append(RACE_RESULT_DELIMITER)
                .append(raceResult.getPositionOfNthRound(n));

        return sb.toString();
    }
}
