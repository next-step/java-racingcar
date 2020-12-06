package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 자동차 경주 게임 클래스
 */
public class RacingGame {

    private final int carCount;     // 자동차 수
    private final int moveCount;    // 이동횟수
    private List<CarName> carNames;    // 자동차 이름 목록
    private final Map<Integer, List<RacingCar>> racingCarMap = new HashMap<>();     // 경주용 자동차 맵

    public RacingGame(int carCount, int moveCount) {
        this.carCount = carCount;
        this.moveCount = moveCount;
        for (int i = 0; i < moveCount; i++) {
            setRacingCarMap(i);
        }
    }

    public RacingGame(List<CarName> carNames, int moveCount) {
        this.carCount = carNames.size();
        this.moveCount = moveCount;
        this.carNames = carNames;
        for (int i = 0; i < moveCount; i++) {
            setRacingCarMapForCarNames(i);
        }
    }

    public Map<Integer, List<RacingCar>> getRacingCarMap() {
        return racingCarMap;
    }

    /**
     * 실행횟수에 따른 경주용 자동차 목록 저장
     * @param racingCarMapKey 실행횟수 번호
     */
    private void setRacingCarMap(int racingCarMapKey) {
        List<RacingCar> racingCarList = new ArrayList<>();
        for (int j = 0; j < carCount; j++) {
            RacingCar car = new RacingCar(moveCount);
            car.race();
            racingCarList.add(car);
        }
        racingCarMap.put(racingCarMapKey, racingCarList);
    }

    /**
     * 실행횟수에 따른 경주용 자동차 목록 저장
     * @param racingCarMapKey 실행횟수 번호
     */
    private void setRacingCarMapForCarNames(int racingCarMapKey) {
        List<RacingCar> racingCarList = new ArrayList<>();
        for (int j = 0; j < carCount; j++) {
            RacingCar car = new RacingCar(moveCount, carNames.get(j));
            car.race();
            racingCarList.add(car);
        }
        racingCarMap.put(racingCarMapKey, racingCarList);
    }

}