package racingcar;

import racingcar.domain.Racing;
import racingcar.view.InputView;
import racingcar.view.RacingPrinter;

import java.util.Scanner;

public class RacingMain {
    public static void main(String[] args) {
        String[] racingCars = InputView.getCarNames();
        int tryCount = InputView.getTryCount();
        Racing racing = new Racing(racingCars);
        System.out.println("실행 결과");
        int tryCountStart = 0;
        while(tryCountStart < tryCount) {
            racing.run();
            RacingPrinter.printRunStatus(racing);
            tryCountStart++;
        }
        RacingPrinter.printFinalWinner(racing.chooseFinalWinners());
    }
}
