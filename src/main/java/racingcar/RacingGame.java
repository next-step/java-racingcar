package racingcar;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 자동차 경주 게임 클래스
 */
public class RacingGame {

    private final int carCount;     // 자동차 수
    private final int moveCount;    // 이동횟수
    private Map<Integer, List<RacingCar>> racingCarMap = new HashMap<>();     // 경주용 자동차 맵
    private List<RacingCar> winners = new ArrayList<>();    // 우승 자동차 목록

    public RacingGame(int carCount, int moveCount) {
        this.carCount = carCount;
        this.moveCount = moveCount;
    }

    public int getCarCount() {
        return carCount;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public Map<Integer, List<RacingCar>> getRacingCarMap() {
        return racingCarMap;
    }
    public void setRacingCarMap(Map<Integer, List<RacingCar>> racingCarMap) {
        this.racingCarMap = racingCarMap;
    }

    public List<RacingCar> getWinners() {
        return winners;
    }

    /**
     * 게임 시작
     */
    public void start() {
        for (int index = 0; index < moveCount; index++) {
            setRacingCarMap(index);
        }
    }

    /**
     * 실행횟수에 따른 경주용 자동차 목록 저장
     * @param racingCarMapKey 실행횟수 번호
     */
    public void setRacingCarMap(int racingCarMapKey) {
        List<RacingCar> racingCarList = new ArrayList<>();
        for (int j = 0; j < carCount; j++) {
            RacingCar car = new RacingCar(moveCount);
            racingCarList.add(car.race());
        }
        racingCarMap.put(racingCarMapKey, racingCarList);
    }

    /**
     * 위치를 통한 우승자 선정
     */
    public void pickWinner() {
        List<RacingCar> candidates = new ArrayList<>();
        for (Integer key : racingCarMap.keySet()) {
            List<RacingCar> racingCarList = racingCarMap.get(key);
            candidates.addAll(getMaxByAdvancedCount(racingCarList));
        }
        this.winners = getMaxByAdvancedCount(candidates).stream()
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * 입력받은 목록 중 전진 횟수가 최대인 RacingCar 목록을 리턴
     * @param racingCarList RacingCar 목록
     * @return 전진 횟수가 최대인 RacingCar 목록
     */
    private List<RacingCar> getMaxByAdvancedCount(List<RacingCar> racingCarList) {
        return racingCarList.stream()
                .collect(Collectors.groupingBy(
                        RacingCar::getAdvancedCount,
                        TreeMap::new,
                        Collectors.toList()))
                .lastEntry()
                .getValue();
    }

}