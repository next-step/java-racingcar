package domain.racingcar;

import domain.racingcar.dto.MovingStrategy;
import domain.racingcar.dto.RacingCar;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private int winnerDistance = Integer.MIN_VALUE;
    private final List<RacingCar> racingCars;

    public RacingCars(int numOfCars) {
        racingCars = new ArrayList<>();

        for (int count = 1; count <= numOfCars; count++) {
            racingCars.add(new RacingCar(0));
        }
    }

    public RacingCars(String[] names) {
        racingCars = new ArrayList<>();

        for (String name : names) {
            racingCars.add(new RacingCar(0, name));
        }
    }

    public RacingCars(int numOfCars, int[] distances, String[] names) {
        racingCars = new ArrayList<>();

        for (int index = 0; index < numOfCars; index++) {
            racingCars.add(new RacingCar(distances[index], names[index]));
        }
    }

    public List<RacingCar> move(MovingStrategy movingStrategy) {
        for (RacingCar racingCar : racingCars) {
            racingCar.move(movingStrategy);
        }

        return racingCars;
    }

    private int findRaceWinnerDistance() {
        for (RacingCar racingCar : racingCars) {
            winnerDistance = Math.max(winnerDistance, racingCar.getDistance());
        }

        if (winnerDistance <= 0) throw new IllegalStateException("우승자가 존재하지 않습니다.");

        return winnerDistance;
    }

    public List<String> findRaceWinners() {
        List<String> raceWinners = new ArrayList<>();
        for (RacingCar racingCar : racingCars) {
            if (racingCar.hasRaceWinnerDistance(findRaceWinnerDistance())) raceWinners.add(racingCar.getName());
        }

        return raceWinners;
    }
}
