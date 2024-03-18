package racingcar.view;

import racingcar.Car;

public class ResultView {

    public void showResult(int times, Car[] carList) {
        if (times == 0) {
            System.out.println("\n실행 결과");
        }

        for (Car car : carList) {
            System.out.println(car.getLocation());
        }

        System.out.println();
    }

}
