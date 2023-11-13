package racing;

import java.util.ArrayList;
import java.util.List;

import static racing.InputView.*;
import static racing.ResultView.*;

public class Racing {
    private static final int START = 1;

    public static void main(String[] args) {
        int carCount = inputCarCount();
        List<Car> carList = new ArrayList<>();
        for(int i = 0; i < carCount; ++i){
            carList.add(new Car());
        }
        int moveCount = inputMoveCount();

        System.out.println("실행 결과");
        doRacing(carList, moveCount);
    }

    public static void doRacing(List<Car> carList, int moveCount) {
        int maxCarMove = START;
        Strategy strategy = new Strategy();

        while(maxCarMove < moveCount){
            for(Car car : carList){
                strategy.setMovable();
                car.moveCar(strategy);
            }

            int currentMaxCarMove = getMaxCarMove(carList);
            if (maxCarMove <= currentMaxCarMove){
                showStatus(carList);
                maxCarMove = currentMaxCarMove;
            }
        }

        showResult(carList, moveCount);
    }


    private static int getMaxCarMove(List<Car> carList) {
        int maxMove = 0;
        for(Car car : carList){
            maxMove = Math.max(maxMove, car.getMoveCount());
        }
        return maxMove;
    }
}