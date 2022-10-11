package step3.car_racing.view;

import step3.car_racing.model.Car;
import step3.car_racing.model.Cars;
import step3.car_racing.service.Racing;

import java.util.List;

public class ResultView {

    private static final String WINNER_MESSAGE = "가 최종 우승 했습니다.";

    private ResultView() {
        // 인스턴스화 방지
        throw new AssertionError();
    }

    public static void result(List<String> carNames, int racingSize) {

        System.out.println();

        System.out.println("실행결과");

        Cars cars = new Cars().initCars(carNames);

        printRacing(new Racing(racingSize, cars));

        System.out.println(printWinner(cars.findWinner()));
    }

    private static void printRacing(Racing racing) {
        for (int i = 0; i < racing.getRaceResult().size(); i++) {
            printCarNameAndDistance(racing.getRaceResult().get(i).getCarList());
        }
    }

    private static void printCarNameAndDistance(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getDistance());
        }
        System.out.println();
    }

    private static String printWinner(List<String> winnerList) {
        return winnerList + WINNER_MESSAGE;
    }

}
