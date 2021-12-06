package racinggame.domain;

import java.util.*;
import java.util.stream.Collectors;

public class RacingCars {
    private static final int RANDOM_NUMBER_BOUND = 10;
    private static final int START_POINT = 0;

    private List<RacingCar> racingCarList;
    private final Random random;

    private RacingCars() {
        this.random = new Random();
    }

    public RacingCars(int carCount) {
        this();
        this.racingCarList = new ArrayList<>(carCount);
        while (racingCarList.size() != carCount) {
            racingCarList.add(new RacingCar(new Distance(START_POINT)));
        }
    }

    public RacingCars(String[] names) {
        this();
        this.racingCarList = new ArrayList<>(names.length);
        for (String name : names) {
            racingCarList.add(new RacingCar(new Distance(START_POINT), new Name(name)));
        }
    }

    public RacingCars(List<RacingCar> racingCarList) {
        this();
        this.racingCarList = racingCarList;
    }

    public RacingCars move() {
        List<RacingCar> newRacingCarList = new ArrayList<>(this.racingCarList.size());
        for (RacingCar racingCar : racingCarList) {
            newRacingCarList.add(racingCar.move(new RamdomCondition(getRandomNumber())));
        }
        this.racingCarList = newRacingCarList;
        return this;
    }

    public RandomValue getRandomNumber() {
        return new RandomValue(this.random.nextInt(RANDOM_NUMBER_BOUND));
    }

    public List<RacingCar> getRacingCars() {
        return Collections.unmodifiableList(racingCarList);
    }

    public List<RacingCar> getWinner() {
        Integer topDistance = racingCarList.stream()
                .map(RacingCar::getDistance)
                .reduce(Integer::max).orElse(0);

        return racingCarList.stream()
                .filter(r -> r.isEqualDistance(new Distance(topDistance)))
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof RacingCars)) {
            return false;
        }

        RacingCars that = (RacingCars) o;
        return this.racingCarList.equals(that.racingCarList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racingCarList);
    }
}
