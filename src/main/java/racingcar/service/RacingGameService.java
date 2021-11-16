package racingcar.service;

import racingcar.domain.RacingCar;

import java.util.*;
import java.util.stream.Collectors;

public class RacingGameService {
    private static final int RANDOM_BOUND = 10;
    private List<String> carNames;
    private int tryCount;

    public RacingGameService(List<String> carNames, int tryCount) {
        this.carNames = carNames;
        this.tryCount = tryCount;
    }

    public List<RacingCar> makeRacingCars() {
        List<RacingCar> racingCarList = new ArrayList<>();
        for (String carName : carNames) {
            racingCarList.add(new RacingCar(carName));
        }
        return racingCarList;
    }

    public void racing(List<RacingCar> racingCars) {
        Random random = new Random();
        for (int i = 0; i < tryCount; i++) {
            goOrStopRacing(racingCars, random);
        }
    }

    private void goOrStopRacing(List<RacingCar> racingCarList, Random random) {
        for (RacingCar racingCar : racingCarList) {
            racingCar.goOrStopRacing(random.nextInt(RANDOM_BOUND));
        }
    }

    public List<RacingCar> getWinners(List<RacingCar> racingCars) {
        return racingCars.stream()
                .filter(racingCar -> racingCar.isMoveCountEqualMaxCount(getMaxCount(racingCars)))
                .collect(Collectors.toList());
    }

    private int getMaxCount(List<RacingCar> racingCars) {
        return racingCars.stream()
                .max(Comparator.comparingInt(RacingCar::getMoveCount))
                .get().getMoveCount();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingGameService that = (RacingGameService) o;
        return tryCount == that.tryCount &&
                Objects.equals(carNames, that.carNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carNames, tryCount);
    }
}
