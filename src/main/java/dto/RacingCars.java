package dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
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

    public void move() {
        for (RacingCar racingCar : racingCars) {
            racingCar.move(racingCar.speedOf());
        }
    }

    public List<Integer> distance() {
        return racingCars.stream().map(RacingCar::getDistance).collect(Collectors.toList());
    }

    public List<String> name() {
        return racingCars.stream().map(RacingCar::getName).collect(Collectors.toList());
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}