package study;


import java.util.Random;

import static study.InputView.askCarCount;
import static study.InputView.askTryCount;
import static study.ResultView.printResult;
import static study.StringAddCalculator.splitAndSum;

public class RacingCar {

    public static void main(String[] args){
        int carCount = 0;
        int tryCount = 0;

        try {

            carCount = splitAndSum(askCarCount());
            tryCount = splitAndSum(askTryCount());

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("숫자 양수로만 입력해주세요.");
        }

        System.out.println("carCount:: " + carCount);
        System.out.println("tryCount:: " + tryCount);

        int[] resultList = getResultList(carCount, tryCount);
        printResult(resultList, tryCount);

    }

    private static int getRandom(int tryCount){
        Random random = new Random();
        return random.nextInt(tryCount)+1;
    }

    private static int[] getResultList(int carCount, int tryCount){
        int[] resultList = new int[carCount];
        for (int i = 0; i < carCount; i++) {
            int num = getRandom(tryCount);
            resultList[i] = num;
            System.out.println("round: "+ i + " // num: " +num);
        }
        return resultList;
    }

}
