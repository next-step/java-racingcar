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

    /**
     * 차량 주행 출력 메소드
     */
    public void printRacing(List<Car> carList) {
        System.out.println();
        for (Car car : carList) {
            System.out.println(car.getDrivingHistory());
        }
    }

}
