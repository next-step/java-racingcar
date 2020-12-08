package racingcar;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 자동차 경주 출력 클래스
 */
public class ResultView {

    private final Map<Integer, List<RacingCar>> racingCarMap;     // 경주용 자동차 맵
    private final List<RacingCar> winners;                        // 우승 자동차 목록

    public ResultView(RacingGame racingGame) {
        this.racingCarMap = racingGame.getRacingCarMap();
        this.winners = racingGame.getWinners();
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
        printWinners();
    }

    /**
     * 자동차 목록별 실행결과 출력
     * @param racingCarList 자동차 목록
     */
    private void printRacingCarList(List<RacingCar> racingCarList) {
        for (RacingCar car : racingCarList) {
            printCarName(car);
            printAdvanced(car.getAdvancedCount());
            System.out.println();
        }
    }

    /**
     * 자동차 이름 출력
     * @param car 경주용 자동차
     */
    private void printCarName(RacingCar car) {
        if (car.isExistName()) {
            System.out.print(car.getCarName().getName() + " : ");
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

    /**
     * 자동차 경주 우승자 출력
     */
    public void printWinners() {
        String winnerCarNames = winners.stream()
                .map(RacingCar::getCarName)
                .map(CarName::getName)
                .collect(Collectors.joining(", "));
        if (winnerCarNames.length() > 0) {
            System.out.println(winnerCarNames + "가 최종 우승했습니다.");
        }
    }
}
