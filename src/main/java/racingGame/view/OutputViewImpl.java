package racingGame.view;

import racingGame.domain.Car;
import racingGame.view.OutputView;

public class OutputViewImpl implements OutputView {
    @Override
    public void viewPrintCarName(Car car) {
        System.out.println(car);
    }

    @Override
    public void viewWinnersName(String[] carsName) {
        System.out.println(String.join(", ", carsName) + "가 최종 우승했습니다.");
    }

    @Override
    public void viewEmptySpace() {
        System.out.println();
    }

    @Override
    public void viewCarsSize(int carSize) {
        System.out.println(carSize);
    }
}
