package step3.domain;

import step3.common.RacingRandom;

import java.util.ArrayList;
import java.util.List;

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

    public List<String> findWinner() {
        int maxPosition = getMaxPosition();
        List<String> winnersClub = new ArrayList<>();

        for (RacingCar car : racingCarList) {
            car.getWinners(winnersClub, maxPosition);
        }

        return winnersClub;
    }
}

