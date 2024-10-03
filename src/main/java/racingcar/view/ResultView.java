package racingcar.view;

import racingcar.model.Car;

public class ResultView {

    public void printCarsStatusResult(Car[] carsStatus) {
        for(int i = 0; i < carsStatus.length; i++) {
            System.out.println(carsStatus[i].currentCarMovingStatus);
        }

        System.out.println();
    }
}
