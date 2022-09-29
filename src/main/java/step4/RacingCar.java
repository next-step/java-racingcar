package step4;

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
