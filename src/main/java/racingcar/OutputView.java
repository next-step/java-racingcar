package racingcar;

import java.util.List;

public class OutputView {
    public void printCarPosition(Car car) {
        System.out.print(car.name() + ": ");
        for (int i = 0; i <= car.position(); i++) {
            System.out.print('-');
        }
        System.out.print('\n');
    }

    public void printCarGroupPosition(CarGroup carGroup) {
        for (int carIndex = 0; carIndex < carGroup.size(); carIndex++) {
            printCarPosition(carGroup.car(carIndex));
        }
        System.out.println("==========");
    }

    public void printWinner(List<String> winnerNames) {
        for (int i = 0; i < winnerNames.size(); i++) {
            System.out.print(winnerNames.get(i) + " ");
        }
        System.out.println("가 최종 우승했습니다.");
    }
}
