package study.racing;

import study.utils.NumberUtils;

import java.util.HashMap;
import java.util.Map;

public class RacingCar {

    public static final String FORWARD = "-";

    public static  void racing() {

        int tryCount = InputView.racingQuestion(RacingMessage.TRY_COUNT.msg());
        int carCount = InputView.racingQuestion(RacingMessage.CAR_COUNT.msg());

        for(int i= 0; i < tryCount; i++) {
            for(int j = 0; j < carCount; j++) {
                int count =0;
                int randomNumber = NumberUtils.randomNumberUnder10();
                boolean isForward = randomNumber >= 4;
                if(isForward) {
                    count++;
                }
                goAndStop(j, count);
            }
        }
    }

    private static void goAndStop(int car, int count) {
        Map<Integer, Integer> map = new HashMap<>();
        if (!map.containsKey(car)) {
            map.put(car, 0);
        }
        int totalCount = map.get(car) + count;
        map.put(car, totalCount);

        resultView(totalCount);
    }

    private static void resultView(int totalCount) {
        for (int k = 0; k < totalCount; k++) {
            System.out.print(FORWARD);
        }
        System.out.println();
    }


}
