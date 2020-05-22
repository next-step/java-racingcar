package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private List<RacingCar> racingCarList = new ArrayList<>();
    private RacingRandom racingRandom = new RacingRandom();

    public List<RacingCar> getRacingCarList() {
        return racingCarList;
    }

    public RacingGame(String[] carNameList) {
        for(String carName : carNameList) {
            racingCarList.add(new RacingCar(carName));
        }
    }

    public void moveCars() {
        for (RacingCar car : racingCarList) {
            int power = racingRandom.getRandomNumber();
            car.move(power);
        }
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

