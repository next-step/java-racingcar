package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.RandomUtil;

public class RacingGame {

    private static final int RANDOM_START = 0;
    private static final int RANDOM_END = 9;

    private final List<RacingCar> racingCars;
    private int tryNo;

    public RacingGame(String carName, int tryNo) {
        racingCars = setRacingCars(carName);
        this.tryNo = tryNo;
    }

    private List<RacingCar> setRacingCars(String carName) {
        return Arrays.stream(carName.split(","))
            .map(RacingCar::new)
            .collect(Collectors.toList());
    }

    public void race() {
        moveCars();
        tryNo--;
    }

    public void moveCars() {
        for (RacingCar car : racingCars) {
            int value = RandomUtil.pickNumberInRange(RANDOM_START, RANDOM_END);
            car.move(value);
        }
    }

    public List<String> getWinners() {
        int maxPosition = maxPosition();
        return getWinnerNames(maxPosition);
    }

    private int maxPosition() {
        return racingCars.stream()
            .mapToInt(RacingCar::getPosition)
            .max().orElseThrow(() -> new IllegalArgumentException("[ERROR] 최대 위치값을 찾는데 실패했습니다."));
    }

    private List<String> getWinnerNames(int maxPosition) {
        return racingCars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .map(RacingCar::getName)
            .collect(Collectors.toList());
    }

    public boolean isEnd() {
        return tryNo == 0;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}

