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

    public void printRacing(List<Car> carList) {
        System.out.println();
        for (Car car : carList) {
            print(car);
        }
    }

    public void print(Car car) {
        for (int i = 0; i < car.getDrivingHistory(); i++) {
            System.out.print(MOVED);
        }
        System.out.println();
    }

}
