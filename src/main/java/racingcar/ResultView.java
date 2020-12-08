package racingcar;

import java.util.ArrayList;
import java.util.List;

public class ResultView {

    /**
     * 자동차의 현재 위치를 받아서 리스트에 담습니다.
     * @param racingCarController
     * @return
     */
    public List<Integer> getNowDistance(RacingCarController racingCarController) {
        List<Integer> nowDistances = new ArrayList<>();
        for (RacingCar racingCar : racingCarController.getRacingCars()) {
            nowDistances.add(racingCar.getDistance());
        }
        return nowDistances;
    }
}
