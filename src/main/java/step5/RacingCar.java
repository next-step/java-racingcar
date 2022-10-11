package step5;

import step5.domain.Car;
import step5.domain.GameRule;
import step5.domain.Winner;
import step5.view.InputView;
import step5.view.ResultView;

import java.util.List;

public class RacingCar {

    public static void main(String[] args) {
        List<Car> carList = InputView.inputCarName();
        int tryNum = InputView.inputTryNum();

        ResultView.printRacingStart();
        for (int i = 0; i < tryNum; i++) {
            exeOneCycle(carList);
            ResultView.printRacingCycleEnd();
        }
        ResultView.printWinner(Winner.getWinner(carList));
    }

    private static void exeOneCycle(List<Car> carList) {
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            GameRule.decideMove(GameRule.createRandomNum(), car);
            ResultView.printResult(car);
        }
    }
}
