package racingcar.service;

import racingcar.domain.RacingCar;
import racingcar.domain.RandomMove;
import racingcar.service.dto.RacingCarDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private static RacingGame INSTANCE = null;

    public static RacingGame getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RacingGame();
        }
        return INSTANCE;
    }


    public boolean isMatching(int matchCount) {
        return matchCount > 0;
    }

    public int match(int matchCount, List<RacingCar> racingCars) {
        if (matchCount > 0) {
            movingCars(racingCars);
            matchCount--;
        }
        return matchCount;
    }

    private void movingCars(List<RacingCar> racingCars) {
        for (RacingCar car : racingCars) {
            car.move(RandomMove.getInstance().movable());
        }
    }

    /**
     * 도메인 계층에서 getter로 전달하면 도메인 계층에 직접 참조하고,
     * getter로 clear하는 문제가 생길 수 있으므로
     * Integer 클래스로 복사해서 반환
     */
    public List<RacingCarDto> getRacingCarsPosition(List<RacingCar> racingCars) {
        List<RacingCarDto> result = new ArrayList<>();
        for (RacingCar racingCar : racingCars) {
            result.add(racingCar.toDto());
        }
        return result;
    }

    public List<RacingCar> createRacingCars(String carNames) {
        List<RacingCar> cars = new ArrayList<>();
        String[] names = carNames.split(",");
        for (String name : names) {
            cars.add(new RacingCar(name));
        }
        return cars;
    }

    public List<String> findWinners(List<RacingCar> racingCars) {
        int maxPosition = 0;
        maxPosition = getMaxPosition(racingCars, maxPosition);
        return getWinnersName(racingCars, maxPosition);
    }

    private static List<String> getWinnersName(List<RacingCar> racingCars, int maxPosition) {
        return racingCars.stream()
                .filter(c -> c.isSamePosition(maxPosition))
                .map(RacingCar::getName)
                .collect(Collectors.toList());
    }

    private static int getMaxPosition(List<RacingCar> racingCars, int maxPosition) {
        for (RacingCar racingCar : racingCars) {
            maxPosition = racingCar.getMaxPosition(maxPosition);
        }
        return maxPosition;
    }
}
