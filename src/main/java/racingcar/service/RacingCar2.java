package racingcar.service;

import java.util.HashMap;
import java.util.List;

public class RacingCar2 {
    final static int PERCENTAGE_NUMBER = 4;
    static int numberOfCars;
    static int numberOfTrials;

    public RacingCar2(List<Integer> inputValues) {
        numberOfCars = inputValues.get(0);
        numberOfTrials = inputValues.get(1);
    }

    public HashMap <Integer, List<Integer>> racingCarMovements(List<Integer> inputValues) {
        HashMap<Integer, List<Integer>> racingResultsByTrials = new HashMap<>();
        randomNumber();

//        carRacingRoute();
//        moveForward(randomNumber());

//        for(int i=0; i<numberOfTrials; i++){
//            map.put(i,)
//        }
        return racingResultsByTrials;
    }

    // random 확률 계산기
    private static int randomNumber() {
        double randomValue = Math.random();
        int probability = (int)(randomValue * 10);

        return probability;
    }

    // 40% 확률로 자동차 이동
    private static boolean moveForward(int probability) {
        return probability >= PERCENTAGE_NUMBER;
    }

//    private static List<String> carRacingRoute() {
//
//    }
}
