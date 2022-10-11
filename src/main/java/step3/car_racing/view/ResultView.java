package step3.car_racing.view;

import step3.car_racing.model.Car;
import step3.car_racing.model.Cars;
import step3.car_racing.service.Racing;

import java.util.List;

import static step3.car_racing.util.WinnerUtil.findWinner;

public class ResultView {

    private ResultView() {
        // 인스턴스화 방지
        throw new AssertionError();
    }

    public static void result(List<String> carNames, int racingSize) {

        System.out.println();

        System.out.println("실행결과");

        Cars cars = new Cars().initCars(carNames);

        Racing racing = new Racing(racingSize, cars);

        printRacing(racing, cars);
    }

    private static void printRacing(Racing racing, Cars cars) {
        for (int i = 0; i < racing.getRaceResult().size(); i++) {
            printCarNameAndDistance(racing.getRaceResult().get(i).getCarList());
        }

        String winner = findWinner(cars);

        System.out.println(winner);
    }

    private static void printCarNameAndDistance(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getDistance());
        }
        System.out.println();
    }

}
