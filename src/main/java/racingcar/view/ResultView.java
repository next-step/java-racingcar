package racingcar.view;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;

import java.util.stream.Collectors;

/**
 * 자동차 경주 출력 클래스
 */
public class ResultView {

    /**
     * 실행결과 출력
     */
    public void print() {
        System.out.println("실행결과");
    }

    /**
     * 자동차 목록별 실행결과 출력
     * @param cars 자동차 목록
     */
    public void printRacingCars(RacingCars cars) {
        for (RacingCar car : cars.getRacingCars()) {
            printCarName(car);
            printAdvanced(car.getAdvancedCount());
            System.out.println();
        }
        System.out.println();
    }

    /**
     * 자동차 이름 출력
     * @param car 경주용 자동차
     */
    private void printCarName(RacingCar car) {
        if (car.isExistName()) {
            System.out.print(car.getCarName() + " : ");
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
    public void printWinners(RacingCars winners) {
        String winnerCarNames = winners.getRacingCars()
                .stream()
                .map(RacingCar::getCarName)
                .collect(Collectors.joining(", "));
        if (winnerCarNames.length() > 0) {
            System.out.println(winnerCarNames + "가 최종 우승했습니다.");
        }
    }
}