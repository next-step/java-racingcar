package step3.view;

import step3.model.Car;

public class ResultView {
    public void showCarLocation(Car car) {
        for (int i = 0; i < car.position; i++) {
            System.out.print('-');
        }
        System.out.println();
    }


}
