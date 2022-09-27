package step4;

import java.util.List;

import static step4.GameRule.createRandomNum;
import static step4.GameRule.decideMove;

public class RacingCar {

    public static List<Car> carList;

    public static void main(String[] args){
        carList = InputView.inputCarName();
        int tryNum = InputView.inputTryNum();

        ResultView.start();
        for (int i = 0; i < tryNum; i++) {
            exeOneCycle(carList.size());
            ResultView.cycleEnd();
        }
    }

    private static void exeOneCycle(int carNum) {
        for (int i = 0; i < carNum; i++) {
            Car car = carList.get(i);
            decideMove(createRandomNum(),car);
            ResultView.resultPrint(car);
        }
    }
}
