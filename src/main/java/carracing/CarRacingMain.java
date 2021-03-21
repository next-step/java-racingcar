package carracing;

import carracing.service.CarRacingService;
import carracing.view.InputView;
import carracing.vo.Car;


public class CarRacingMain {

    public static void main(String[] args) {
        Car car = new InputView().input();
        new CarRacingService().startRacing(car);
    }
}
