package racingcar.view;

import racingcar.domain.Cars;

public class ResultView {

    public void printResult() {
        System.out.println("실행 결과");
    }

    public void printCars(Cars cars) {
        System.out.println(cars.getRaceStatusString());
        System.out.println();
    }

    public void printWinners(Cars winnerCars) {
        String winnerCarNames = winnerCars.getWinnerCarNames();
        System.out.println(winnerCarNames + "가 최종 우승했습니다.");
    }
}
