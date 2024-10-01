package carracing;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RacingCar {

    public static final int BOUND = 10;
    public static final int MIN_MOVE_VALUE = 4;

    private static final Random RANDOM = new Random();

    public boolean shouldMove(int randomValue) {
        return randomValue >= MIN_MOVE_VALUE;
    }

    public Map<Integer, Integer> race(int carNumbers, int moveNumbers) {
        Map<Integer, Integer> carPositions = initCarsMap(carNumbers);
        repeatMove(carNumbers, moveNumbers, carPositions);
        return carPositions;
    }

    private void repeatMove(int carNumbers, int moveNumbers, Map<Integer, Integer> carPositions) {
        for (int move = 1; move <= moveNumbers; move++) {
            recordCarMove(carNumbers, carPositions);
        }
    }

    // 차량 이동 기록
    private void recordCarMove(int carNumbers, Map<Integer, Integer> carPositions) {
        for (int carNumber = 1; carNumber <= carNumbers; carNumber++) {
            addNowCarMove(carPositions, carNumber);
            System.out.print(printNowCarMoves(carPositions.get(carNumber)));
            System.out.println();
        }
        System.out.println();
    }

    private void addNowCarMove(Map<Integer, Integer> carPositions, int carNumber) {
        if (shouldMove(RANDOM.nextInt(BOUND))) {
            carPositions.put(carNumber, carPositions.get(carNumber) + 1);
        }
    }

    // 차량 초기화
    private Map<Integer, Integer> initCarsMap(int carNums) {
        Map<Integer, Integer> carsMap = new HashMap<>();

        for (int i = 1; i <= carNums; i++) {
            carsMap.put(i, 0);
        }
        return carsMap;
    }

    private String printNowCarMoves(int nowCarMoves) {
        return "-".repeat(nowCarMoves);
    }
}
