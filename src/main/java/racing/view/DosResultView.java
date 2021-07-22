package racing.view;

import racing.car.Car;
import racing.car.Cars;

public class DosResultView implements ResultView {
    @Override
    public void printResultTitle() {
        System.out.println("실행 결과");
        System.out.println();
    }

    @Override
    public void printAllCarLocation(Cars cars) {
        for (Car iCar : cars) {
            System.out.println(iCar.getLocation());
        }
        System.out.println();
    }
}
