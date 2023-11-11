package racing;

import java.util.Arrays;
import java.util.Random;

import static racing.InputView.*;
import static racing.ResultView.*;

public class Racing {
    private static final int START = 1;
    private static final int MAX_RANDOM_NUMBER = 10;
    private static final int MOVE_THRESHOLD = 4;

    public static void main(String[] args) {
        Car[] cars = new Car[inputCarCount()];
        for(int index = 0; index < cars.length; ++index){
            cars[index] = new Car();
        }
        int moveCount = inputMoveCount();

        System.out.println("실행 결과");
        doRacing(cars, moveCount);
    }

    public static void doRacing(Car[] cars, int moveCount) {
        int maxCarMove = START;
        while(maxCarMove < moveCount){
            for(Car car : cars){
                if (checkMove()){
                    car.moveCar();
                }
            }

            int currentMaxCarMove = getMaxCarMove(cars);
            if (maxCarMove <= currentMaxCarMove){
                showStatus(cars);
                maxCarMove = currentMaxCarMove;
            }
        }

        showResult(cars, moveCount);
    }

    public static boolean checkMove() {
        Random random = new Random();
        return random.nextInt(MAX_RANDOM_NUMBER) >= MOVE_THRESHOLD;
    }

    private static int getMaxCarMove(Car[] cars) {
        int maxMove = 0;
        for(Car car : cars){
            maxMove = Math.max(maxMove, car.getMoveCount());
        }
        return maxMove;
    }
}