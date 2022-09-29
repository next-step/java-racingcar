import java.util.ArrayList;
import java.util.List;

public class RacingCarService {

    public List<String> findRaceWinners(RacingCars racingCars) {
        int raceWinnerDistance = findRaceWinnerDistance(racingCars.distance());
        return findRaceWinners(racingCars.getRacingCars(), raceWinnerDistance);
    }

    private int findRaceWinnerDistance(List<Integer> distances) {
        int result = Integer.MIN_VALUE;

        for (int distance : distances) {
            result = Math.max(result, distance);
        }

        return result;
    }


    private List<String> findRaceWinners(List<RacingCar> racingCars, int raceWinnerDistance) {
        List<String> raceWinners = new ArrayList<>();
        for (RacingCar racingCar : racingCars) {
            if (racingCar.getDistance() == raceWinnerDistance) raceWinners.add(racingCar.getName());
        }

        return raceWinners;
    }
}
