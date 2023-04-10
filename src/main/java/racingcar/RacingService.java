package racingcar;

import java.util.ArrayList;
import java.util.Random;

public class RacingService {
    public ArrayList<CarInfo> getCarInfos(RacingInfo racingInfo) {
        return racingInfo.getCarInfos();
    }

    public void moveByNumOfTriesAndShowResult(RacingInfo racingInfo) {
        ResultView resultView = new ResultView();
        for (int i = 0; i < racingInfo.getNumOfTries(); i++) {
            move(racingInfo);
            resultView.showCurrentState(getCarInfos(racingInfo));
        }
    }

    public void move(RacingInfo racingInfo) {
        racingInfo.getCarInfos().stream()
                .map(carInfo -> {
                    carInfo.setResultOfRand(getRand(10));
                    return carInfo;
                })
                .filter(carInfo -> carInfo.getResultOfRand() > 4)
                .forEach(CarInfo::moveFoward);
    }

    private int getRand(int bound) {
        int rand = new Random().nextInt(bound);
        return rand;
    }
}
