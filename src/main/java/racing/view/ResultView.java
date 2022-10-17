package racing.view;

import racing.domain.Car;
import racing.domain.Cars;

public class ResultView {
    private static final String DASH = "-";

    public static void init() {
        System.out.println("실행 결과");
    }

    public void result(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.print(car.getName() + " : " + DASH.repeat(car.getDistance()));
            System.out.println("");
        }
    }

    public void printWinner(Car winnerCar) {
        System.out.println("");
        System.out.println(winnerCar.getName() + "가 최종 우승했습니다.");
    }
}
