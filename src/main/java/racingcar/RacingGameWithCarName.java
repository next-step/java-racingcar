package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGameWithCarName extends RacingGame {

    private final List<CarName> carNames;     // 자동차 이름 목록

    public RacingGameWithCarName(List<CarName> carNames, int moveCount) {
        super(carNames.size(), moveCount);
        this.carNames = carNames;
    }

    /**
     * 실행횟수에 따른 경주용 자동차 목록 저장
     * @param racingCarMapKey 실행횟수 번호
     */
    public void setRacingCarMap(int racingCarMapKey) {
        List<RacingCar> racingCarList = new ArrayList<>();
        for (int j = 0; j < getCarCount(); j++) {
            RacingCar car = new RacingCar(getMoveCount(), carNames.get(j));
            racingCarList.add(car.race());
        }
        getRacingCarMap().put(racingCarMapKey, racingCarList);
    }

}
