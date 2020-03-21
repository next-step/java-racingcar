package racingcar.domain;

import racingcar.view.ResultView;

public class Car {
    private int position;

    public void move(int moveCount) {
        position += moveCount;
    }

    public void printPosition() {
        ResultView.printPosition(position);
    }
}
