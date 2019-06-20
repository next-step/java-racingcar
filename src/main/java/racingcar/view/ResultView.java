package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public interface ResultView {
    void printCurrentRound(final int round);
    void addLineBreak();
    void printCurrentPositionOf(final Car car);
    void printWinner(final String names);
}
