package racingcar;

import java.util.*;

public class Racing {

    public void runRacing(List<Car> carList, int tryNumber) {
        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < tryNumber; i++) {
            runCarsForOneTurn(carList);
            System.out.println();
        }
    }

    private void runCarsForOneTurn(List<Car> carList) {
        carList.stream().forEach(car -> {
            car.move(new RandomValue());
            System.out.print(car.getName() + " : ");
            OutputView.printCarTraceUntilNow(car.showNowPosition());
            System.out.println();
        });
    }
}
