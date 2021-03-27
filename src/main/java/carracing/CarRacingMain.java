package carracing;

import carracing.service.CarRacing;
import carracing.view.InputView;
import carracing.vo.Car;


public class CarRacingMain {

    public static void main(String[] args) {
        Car car = InputView.input();
        CarRacing.start(car);
    }
}
