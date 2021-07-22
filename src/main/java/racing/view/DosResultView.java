package racing.view;

import racing.car.Car;
import racing.car.Cars;

public class DosResultView implements ResultView {
    private static final char LOCATION_UNIT = '-';
    @Override
    public void printResultTitle() {
        System.out.println("실행 결과");
        System.out.println();
    }

    @Override
    public void printAllCarLocation(Cars cars) {
        for (Car iCar : cars)
            printCarLocation(iCar);
    }

    @Override
    public void printCarLocation(Car car) {
        int locationValue = car.getLocation().getValue();
        System.out.print(LOCATION_UNIT); // 자동차가 존재한다는 표시
        for (int i = 0; i < locationValue; i++) {
            System.out.print(LOCATION_UNIT);
        }
        System.out.println();
    }
}
