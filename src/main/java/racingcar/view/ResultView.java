package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class ResultView {

    private final String EXECUTE_RESULT = "실행 결과";
    private final String RESULT_SUFFIX = "가 최종 우승했습니다.";

    public void printRaceStep(Cars cars) {
        cars.getCars().forEach(car -> {
            printCarName(car);
            printCarPosition(car);
            System.out.println();
        });
        System.out.println();
    }

    private void printCarPosition(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
    }

    private void printCarName(Car car) {
        System.out.print(car.getName() + " : ");
    }

    public void printWinner(Cars cars) {
        System.out.println(cars.findWinner() + RESULT_SUFFIX);
    }

    public void printExecuteResult() {
        System.out.println(EXECUTE_RESULT);
    }
}
