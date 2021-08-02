package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class ResultView {
    public static final String RESULT = "실행 결과";
    private static final String LINE = "-";

    public void printLine(Cars cars) {
        for(int i = 0; i < cars.getCarsSize(); i ++) {
            Car car = cars.getCars().get(i);
            System.out.println();
            System.out.print(car.getName() + " ");
            for(int j = 0; j < car.getPosition(); j ++) {
                System.out.print(LINE);
            }
        }
    }

    public void printWinner(Cars cars) {
        for(Car winners : cars.findWinner()) {
            System.out.print(winners.getName() + " ");
        }
        System.out.print("가 최종 우승 했습니다.");
    }
}
