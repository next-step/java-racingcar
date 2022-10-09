package step5;

import step5.domain.Car;
import step5.domain.GameRule;
import step5.domain.Winner;
import step5.view.InputView;
import step5.view.ResultView;

import java.util.List;

public class RacingCar {

    public static List<Car> carList;

    public static void main(String[] args) {
        carList = InputView.inputCarName();
        int tryNum = InputView.inputTryNum();

        ResultView.start();
        for (int i = 0; i < tryNum; i++) {
            exeOneCycle(carList.size());
            ResultView.cycleEnd();
        }
        ResultView.printWinner(Winner.getWinner(carList));
    }

    private static void exeOneCycle(int carNum) {
        for (int i = 0; i < carNum; i++) {
            Car car = carList.get(i);
            GameRule.decideMove(GameRule.createRandomNum(), car);
            ResultView.printResult(car);
        }
    }
}
