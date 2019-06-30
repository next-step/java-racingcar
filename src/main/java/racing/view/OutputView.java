package racing.view;

import racing.model.Cars;

public class OutputView {

    public static void showCarsProcess(Cars cars) {
        cars.getCars().forEach(car -> System.out.println(car.getName() + ":" + car.getDistance()));
        System.out.println();
    }

    public static void showWinner(Cars cars) {
        System.out.print(cars.getWinnersName() + "가 우승하셨습니다.");
    }
}
