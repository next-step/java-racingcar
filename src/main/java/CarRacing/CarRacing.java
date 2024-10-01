package carracing;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CarRacing {

    public static final int BOUND = 10;
    public static final int MIN_MOVE_VALUE = 4;

    private static final Random RANDOM = new Random();

    public boolean shouldMove(int randomValue) {
        return randomValue >= MIN_MOVE_VALUE;
    }

    public Map<Integer, Integer> race(int carNums, int moveNums) {
        Map<Integer, Integer> carsMap = initCarsMap(carNums);
        repeatMove(carNums, moveNums, carsMap);
        return carsMap;
    }

    private void repeatMove(int carNums, int moveNums, Map<Integer, Integer> carsMap) {
        for(int k=1; k<= moveNums; k++) {
            recordCarMove(carNums, carsMap);
        }
    }

    // 차량 이동 기록
    private void recordCarMove(int carNums, Map<Integer, Integer> carsMap) {
        for(int i=1; i<=carNums; i++) {
            addNowCarMove(carsMap, i);
            ResultView.printNowCarMoves(carsMap.get(i));
            ResultView.lineChange();
        }
        ResultView.lineChange();
    }

    private void addNowCarMove(Map<Integer, Integer> carsMap, int carNum) {
        if(shouldMove(RANDOM.nextInt(BOUND))) {
            carsMap.put(carNum, carsMap.get(carNum) + 1);
        }
    }

    // 차량 초기화
    private static Map<Integer, Integer> initCarsMap(int carNums) {
        Map<Integer, Integer> carsMap = new HashMap<>();

        for(int i=1; i<=carNums; i++) {
            carsMap.put(i, 0);
        }
        return carsMap;
    }
}
