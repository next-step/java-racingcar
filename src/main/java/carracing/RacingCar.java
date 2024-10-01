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
        repeatMove(moveNumbers, moveNumbers, carPositions);
        return carPositions;
    }

    private void repeatMove(int carNums, int moveNums, Map<Integer, Integer> carPositions) {
        for (int k = 1; k <= moveNums; k++) {
            recordCarMove(carNums, carPositions);
        }
    }

    // 차량 이동 기록
    private void recordCarMove(int carNums, Map<Integer, Integer> carPositions) {
        for (int i = 1; i <= carNums; i++) {
            addNowCarMove(carPositions, i);
            ResultView.printNowCarMoves(carPositions.get(i));
            ResultView.lineChange();
        }
        ResultView.lineChange();
    }

    private void addNowCarMove(Map<Integer, Integer> carsMap, int carNum) {
        if (shouldMove(RANDOM.nextInt(BOUND))) {
            carsMap.put(carNum, carsMap.get(carNum) + 1);
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
}
