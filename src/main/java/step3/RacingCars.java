package step3;

import java.util.*;
import java.util.stream.Collectors;

public class RacingCars {
    private static final int RANDOM_NUMBER_BOUND = 10;

    private List<RacingCar> racingCarList;
    private final Random random;

    private RacingCars() {
        this.random = new Random();
    }

    public RacingCars(int carCount) {
        this();
        racingCarList = new ArrayList<>(carCount);
        while (racingCarList.size() != carCount) {
            racingCarList.add(new RacingCar(new Distance(0)));
        }
    }

    public RacingCars(String[] names) {
        this();
        racingCarList = new ArrayList<>(names.length);
        for(String name : names) {
            racingCarList.add(new RacingCar(new Distance(0), new Name(name)));
        }
    }

    public RacingCars move() {
        List<RacingCar> newRacingCarList = new ArrayList<>(this.racingCarList.size());
        for (RacingCar racingCar : racingCarList) {
            newRacingCarList.add(racingCar.move(new RamdomCondition(new RandomValue(this.random.nextInt(RANDOM_NUMBER_BOUND)))));
        }
        this.racingCarList = newRacingCarList;
        return this;
    }

    public List<RacingCar> getRacingCars() {
        return Collections.unmodifiableList(racingCarList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCars that = (RacingCars) o;
        return this.racingCarList.equals(that.racingCarList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racingCarList);
    }
}
