package step3.domain;

import step3.common.RacingRandom;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private List<RacingCar> racingCarList = new ArrayList<>();
    private RacingRandom racingRandom = new RacingRandom();

    public RacingGame(String[] carNameList) {
        for (String carName : carNameList) {
            racingCarList.add(new RacingCar(carName));
        }
    }

    public List<RacingCar> moveCars() {
        for (RacingCar car : racingCarList) {
            int power = racingRandom.getRandomNumber();
            car.move(power);
        }

        return racingCarList;
    }

    public int getMaxPosition() {
        return racingCarList.stream()
                .mapToInt(RacingCar::getCurrentPosition)
                .max()
                .getAsInt();
    }

    public List<RacingCar> findWinner() {
        int maxPosition = getMaxPosition();

        return racingCarList.stream()
                .filter(car -> car.samePosition(maxPosition))
                .collect(Collectors.toList());
    }
}

