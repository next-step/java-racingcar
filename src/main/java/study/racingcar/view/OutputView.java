package study.racingcar.view;

import study.racingcar.domain.Car;
import study.racingcar.dto.RacingResult;
import study.racingcar.dto.WinnerResults;

public class OutputView {

    public void printRacingResult(RacingResult racingResult) {
        racingResult.getResults()
            .forEach(this::printCarResult);
        System.out.println();
    }

    public void printCarResult(Car car) {
        System.out.printf("%s: ", car.getName());
        for (int i = 0; i <= car.getPosition().getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printWinner(WinnerResults winners) {
        String winnerNames = winners.getWinnerNames();
        System.out.printf("%s 가 최종 우승했습니다.\n", winnerNames);
    }
}
