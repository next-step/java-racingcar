package carracing;

import java.util.List;


/*
 * ResultView
 *
 * Version 1.0.0
 *
 * 2021-11-08
 *
 * author jiseok-choi
 */
public class ResultView {

    private static final String MOVED = "-";        /* 차량 움직임 */
    private static final String CAR_NAME = "%s : ";

    public void printRacing(List<Car> carList) {
        for (Car car : carList) {
            System.out.println();
            print(car);
        }
        System.out.println();
    }

    public void print(Car car) {
        System.out.printf(CAR_NAME, car.getName());
        for (int i = 0; i < car.getDrivingHistory(); i++) {
            System.out.print(MOVED);
        }
    }

}
