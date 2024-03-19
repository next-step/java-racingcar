package racingcar;

import java.util.List;

public class OutputView {
    public void printCarPosition(Car car) {
        // 입력변수를 Car 하나로 두면 깔끔하긴 한데 캡슐화가 깨지는 거 같음
        System.out.print(car.carName() + ": ");
        for (int i = 0; i <= car.position(); i++) {
            System.out.print('-');
        }
        System.out.print('\n');
    }

    public void printCarGroupPosition(CarGroup carGroup) {
        for (int carIndex = 0; carIndex < carGroup.carGroupSize(); carIndex++) {
            printCarPosition(carGroup.Car(carIndex));
        }
        System.out.println("==========");
    }

    public void printWinner(CarGroup carGroup) {
        List<Car> winners = carGroup.winners();
        for (int i = 0; i < winners.size(); i++){
            System.out.print(winners.get(i).carName() + " ");
        }
        System.out.println("가 최종 우승했습니다.");
    }
}
