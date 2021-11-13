package com.rick.racing;

import java.util.List;

public class ResultView {

    public void showResult(int numberOfCars, int numberOfTries,
        List<List<Integer>> racingResult) {
        System.out.println("실행 결과");

        for (int tryIndex = 0; tryIndex < numberOfTries; tryIndex++) {
            for (int carIndex = 0; carIndex < numberOfCars; carIndex++) {
                List<Integer> record = racingResult.get(carIndex);
                int carPosition = record.get(tryIndex);

                for (int i = 0; i < carPosition; i++) {
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
