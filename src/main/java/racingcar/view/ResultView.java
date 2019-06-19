package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public interface ResultView {
    void printCurrentRound(int round);
    void addLineBreak();
    void printCurrentPositionOf(Car car);
    void printWinner(List<Car> cars);
}
