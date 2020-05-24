package game.view;

import game.domain.Car;

import java.util.List;

public interface RacingGameResultView {
    public void printRound(int round);

    public void printResult(Car car);

    public void announceWinner(List<Car> carList);
}
