package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RaceWinner {

    public static List<String> raceWinner(RaceResults raceResults) {
        List<String> result = new ArrayList<>();
        int maxPosition = Car.SET_POSITION;
        for (Car car : raceResults.finalResult().cars()) {
            if (car.position() < maxPosition) {
                continue;
            }
            if (car.position() > maxPosition) {
                result = new ArrayList<>();
                maxPosition = car.position();
            }
            result.add(car.name());
        }
        return result;
    }

}
