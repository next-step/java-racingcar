package racing.car.game;

import racing.car.view.InputView;
import racing.car.view.ResultView;

public class RacingGame {

    public static void main(String[] args) {
        InputView input = new InputView();
        int carNumber = input.carInput();
        int count = input.cntInput();

        ResultView.startCycle(carNumber, count);
        countCarGoAndStop(count, carNumber);
    }

    /**
     * 주어진 횟수 동안 n대의 자동차가 전진 또는 멈추는 기능
     */
    public static void countCarGoAndStop(int count, int carCount) {
        int[] cars = new int[carCount];
        while (count > 0) {
            count--;
            RacingCalculator.carToArrayRandomValues(cars);
            ResultView.resultGoAndStop(cars);
        }
    }
}
