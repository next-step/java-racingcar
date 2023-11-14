package racing;

import java.util.ArrayList;
import java.util.List;

import static racing.InputView.*;
import static racing.ResultView.*;

public class Racing {

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
        for(int i = 0; i < moveCount; ++i){
            moveCars(carList);
        }

        showResult(carList);
    }

    private static void moveCars(List<Car> carList) {
        Strategy strategy = new RandomStrategy();
        
        for(Car car : carList){
            car.moveCar(strategy);
        }

        showStatus(carList);
    }
}