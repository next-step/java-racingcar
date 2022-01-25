package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingPlaying {

    private final List<RacingCar> racingCarList;
    StringBuilder racingStatus = new StringBuilder();

    public RacingPlaying(List<String> nameList) {
        racingCarList = new ArrayList<>();
        for (String name : nameList) {
            racingCarList.add(new RacingCar(name));
        }
    }

    public String getGameStatus(int raceCount) {
        while(raceCount > 0) {
            moveForwardAll();
            raceCount--;
        }
        return racingStatus.toString();
    }

    public List<String> getGameWinner() {
        Winner winner = new Winner(racingCarList);
        List<String> winnerList = winner.chooseWinner();
        return winnerList;
    }

    public void moveForwardAll() {
        for (RacingCar racingCar : racingCarList) {
            racingCar.moveForward();
            racingStatus.append(racingCar.getName() + ":" + racingCar.getPosition() + "\n");
        }
        racingStatus.append("----------------\n");
    }

}
