package game.ui;

import game.Car;

public interface RacingGameResultView {
    public void printRound(int round);

    public void printResult(Car car);
}
