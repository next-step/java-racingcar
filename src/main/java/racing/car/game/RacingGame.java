package racing.car.game;

import racing.car.Car;
import racing.car.CarFactory;
import racing.car.view.InputView;
import racing.car.view.ResultView;

import java.util.List;

public class RacingGame {

    public static void main(String[] args) {
        InputView input = new InputView();
        int carNumber = input.carInput();
        int count = input.cntInput();

        List<Car> carList = CarFactory.makeCar(carNumber);
        racingCycle(carList, count);
    }

    /**
     * 주어진 사이클 동안 레이싱하는 기능
     * */
    private static void racingCycle(List<Car> carList, int count) {
        int cycle = 0;
        while (count > 0) {
            count--;
            carGoAndStop(carList);

            cycle++;
            ResultView.endCycle(cycle);
        }
    }

    private static void carGoAndStop(List<Car> carList) {
        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).isGo(RacingCalculator.getRandomNumber());
            ResultView.resultGoAndStop(carList.get(i));
        }
    }

}
