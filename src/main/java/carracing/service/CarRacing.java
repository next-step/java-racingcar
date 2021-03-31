package carracing.service;

import carracing.view.ResultView;
import carracing.vo.Car;

public class CarRacing {

    public static void start(Car car) {
        car.initializeRacingResult();

        for (int tryCnt = 0; tryCnt <= car.getTryCount() ; tryCnt++) {
            System.out.println( (tryCnt+1) + " 회차");

            car.racing();
            ResultView.print(car);
        }
    }

}
