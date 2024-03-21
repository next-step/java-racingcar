package racingcar;

import java.util.List;

public class OutputView {
    public void printCarPosition(Car car) {
        // 입력변수를 Car 하나로 두면 깔끔하긴 한데 캡슐화가 깨지는 거 같음
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
