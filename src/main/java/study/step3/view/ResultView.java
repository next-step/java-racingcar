package study.step3.view;

import study.step3.model.car.Car;

public class ResultView {

    private static final String DISTANCE_SEPERATOR = "-";

    public void printCarDistance(Car car) {
        for (int i = 0; i < car.getDistance(); i++) {
            System.out.print(DISTANCE_SEPERATOR);
        }
        System.out.println();
    }

}
