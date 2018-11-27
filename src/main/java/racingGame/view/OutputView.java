package racingGame.view;

import racingGame.domain.Car;

public interface OutputView {
    void viewPrintCarName(Car car);
    void viewWinnersName(String[] carsName);
    void viewEmptySpace();
    void viewCarsSize(int carSize);
}
