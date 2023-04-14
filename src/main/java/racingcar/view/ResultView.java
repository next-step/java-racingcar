package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class ResultView {

    private final String EXECUTE_RESULT = "실행 결과";

    public void printResult(Cars cars) {
        System.out.println(EXECUTE_RESULT);
        cars.getCars().forEach(car -> {
            printCarName(car);
            printCarPosition(car);
            System.out.println();
        });
    }

    private void printCarPosition(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
    }

    private void printCarName(Car car) {
        System.out.print(car.getName() + " : ");
    }
}
