package racingcar;

import java.util.List;
import java.util.Map;

/**
 * 자동차 경주 출력 클래스
 */
public class ResultView {

    private Map<Integer, List<RacingCar>> racingCarMap;

    public ResultView(RacingGame racingGame) {
        this.racingCarMap = racingGame.getRacingCarMap();
    }

    /**
     * 실행결과 출력
     */
    public void print() {
        System.out.println("실행결과");
        for (Integer key : racingCarMap.keySet()) {
            printRacingCarList(racingCarMap.get(key));
            System.out.println();
        }
    }

    /**
     * 자동차 목록별 실행결과 출력
     * @param racingCarList 자동차 목록
     */
    private void printRacingCarList(List<RacingCar> racingCarList) {
        for (RacingCar car : racingCarList) {
            printAdvanced(car.getAdvancedCount());
            System.out.println();
        }
    }

    /**
     * 자동차 전진 결과 출력
     * @param advancedCount 전진횟수
     */
    private void printAdvanced(int advancedCount) {
        for (int i = 0; i < advancedCount; i++) {
            System.out.print("-");
        }
    }

}
