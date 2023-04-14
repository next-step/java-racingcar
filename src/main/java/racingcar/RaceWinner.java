package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RaceWinner {

    private static List<String> raceWinner = new ArrayList<>();

    public static List<String> raceWinner(RaceResults raceResults) {
        int winningPosition = Car.SET_POSITION;
        for (Car car : finalCars(raceResults)) {
            winningPosition = winningPosition(car, winningPosition);
        }
        return raceWinner;
    }

    private static List<Car> finalCars(RaceResults raceResults) {
        return raceResults.finalResult().cars();
    }

    private static int winningPosition(Car car, int maxPosition) {
        if (car.position() < maxPosition) {
            return maxPosition;
        }
        if (car.position() > maxPosition) {
            raceWinner = new ArrayList<>();
        }
        raceWinner.add(car.name());
        return car.position();
    }

}
