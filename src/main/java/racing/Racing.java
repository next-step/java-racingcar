package racing;

import java.util.ArrayList;
import java.util.List;

import static racing.InputView.*;
import static racing.ResultView.*;
import static racing.Validate.*;

public class Racing {

    public static void main(String[] args) {
        String[] carNames = inputCarCount();

        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        int moveCount = inputMoveCount();

        doRacing(cars, moveCount);

        showResult(getWinners(cars));
    }

    public static void doRacing(List<Car> cars, int moveCount) {
        System.out.println("실행 결과");
        Strategy strategy = new RandomStrategy();

        for (int i = 0; i < moveCount; ++i) {
            moveCars(cars, strategy);
            showStatus(cars);
        }
    }

    private static void moveCars(List<Car> cars, Strategy strategy) {
        for (Car car : cars) {
            car.moveCar(strategy);
        }
    }

    private static List<String> getWinners(List<Car> cars) {
        List<String> winners = new ArrayList<>();

        int maxMoveCount = getMaxMoveCount(cars);
        for (Car car : cars) {
            if(car.getMoveCount() == maxMoveCount){
                winners.add(car.getCarName());
            }
        }

        return winners;
    }

    private static int getMaxMoveCount(List<Car> cars) {
        int maxMove = 0;
        for (Car car : cars) {
            maxMove = Math.max(maxMove, car.getMoveCount());
        }
        return maxMove;
    }
}