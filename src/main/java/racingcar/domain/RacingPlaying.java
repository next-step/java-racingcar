package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.util.RandomUtil;

public class RacingPlaying {

    private static final int RANDOM_START = 0;
    private static final int RANDOM_END = 9;
    private final List<RacingCar> racingCarList;
    StringBuilder racingStatus = new StringBuilder();


    public List<RacingCar> getRacingCarList() {
        return racingCarList;
    }

    public RacingPlaying(List<String> nameList) {
        racingCarList = new ArrayList<>();
        for (String name : nameList) {
            racingCarList.add(new RacingCar(name));
        }
    }

    public String getGameStatus(int raceCount) {
        while (raceCount > 0) {
            moveForwardAll(RandomUtil.pickNumberInRange(RANDOM_START, RANDOM_END));
            raceCount--;
        }
        return racingStatus.toString();
    }

    public List<String> getGameWinner() {
        Winner winner = new Winner(racingCarList);
        return winner.chooseWinner();
    }

    public void moveForwardAll(int randomNumber) {
        for (RacingCar racingCar : racingCarList) {
            racingCar.moveForward(randomNumber);
            racingStatus.append(racingCar.getName() + ":" + racingCar.getPosition() + "\n");
        }
        racingStatus.append("----------------\n");
    }

}
