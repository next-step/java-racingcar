package racingcar;

import racingcar.domains.RacingCar;
import racingcar.utils.NumberUtil;
import racingcar.views.InputView;
import racingcar.views.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RaceMain {

    public void init() {
        Map<String, Integer> racingCarInfos = InputView.getInput();
        main(racingCarInfos);
    }

    public void main(Map<String, Integer> racingCarInfos) {
        int totalCarNum = racingCarInfos.get(InputView.KEY_TOTAL_CAR_NUM);
        int totalMoveCnt = racingCarInfos.get(InputView.KEY_TOTAL_MOVE_CNT);

        List<RacingCar> racingCars = new ArrayList<>();
        initiateCarInstances(racingCars, totalCarNum);

        ResultView.printResultStr();
        startRace(racingCars, totalMoveCnt);
    }

    private void startRace(List<RacingCar> racingCars, int totalMoveCnt) {
        for (int i = 0; i<totalMoveCnt; i++) {
            makeMoveEachCar(racingCars);
            ResultView.printEmptyLine();
        }
    }

    private void makeMoveEachCar(List<RacingCar> racingCars) {
        for (RacingCar car : racingCars) {
            moveForward(car);
            ResultView.printEachCarMovePath(car);
        }
    }

    private void moveForward(RacingCar car) {
        int ramdomNum = NumberUtil.randomNumberGenerator();
        if (NumberUtil.isAboveFour(ramdomNum)) {
            car.moveForward();
        }
    }

    private void initiateCarInstances(List<RacingCar> racingCars, int totalCarNum) {
        for (int i=0; i<totalCarNum; i++) {
            racingCars.add(new RacingCar());
        }
    }
}
