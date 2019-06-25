package racing.view;

import racing.Car;

public class OutputView {

    public static void showCarsProcess(Car car) {
        System.out.println(car.getName() + ":" + new String(new char[car.getPosition()]).replace("\0", "-"));
    }


}
