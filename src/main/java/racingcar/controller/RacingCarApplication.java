package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarGroup;
import racingcar.domain.Racing;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.Scanner;

public class RacingCarApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playerGroup = InputView.receiveCarNumber(scanner);
        int cycleCount = InputView.receiveTryNumber(scanner);

        List<Car> cars = Racing.makeCars(playerGroup);
        Racing racing = new Racing(new CarGroup(cars));
        OutputView.resultIntro();
        for (int i = 0; i < cycleCount; i++) {
            OutputView.printCarGroupTrace(racing.runRacing());
        }

        List<String> winnerNames = CarGroup.extractWinnerNames(cars);
        OutputView.printWinnerNames(winnerNames);
    }
}
