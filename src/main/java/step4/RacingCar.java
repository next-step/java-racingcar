package step4;

import java.util.List;

import static step4.GameRule.createRandomNum;
import static step4.GameRule.decideMove;
import static step4.InputView.inputCarName;
import static step4.InputView.inputTryNum;
import static step4.ResultView.*;
import static step4.Winner.*;

public class RacingCar {

    public static List<Car> carList;

    public static void main(String[] args) {
        carList = inputCarName();
        int tryNum = inputTryNum();

        start();
        for (int i = 0; i < tryNum; i++) {
            exeOneCycle(carList.size());
            cycleEnd();
        }
        getWinner(getWinner(carList));
    }

    private static void exeOneCycle(int carNum) {
        for (int i = 0; i < carNum; i++) {
            Car car = carList.get(i);
            decideMove(createRandomNum(), car);
            resultPrint(car);
        }
    }
}
