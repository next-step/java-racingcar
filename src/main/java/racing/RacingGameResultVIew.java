package racing;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RacingGameResultVIew {

    private final static String PRINT_CAR_PISITION = "-";

    public static void racingResultView(RacingGameResult rgr) {
        System.out.println("실행 결과");

        // 운행횟수반복
        for (int time = 1; time <= rgr.getTime(); time++) {
            roundRacingHistory(rgr.getRoundHistory(), time);
            System.out.println();
        }

        // 최종우승
        List<String> winners = rgr.getWinners();
        System.out.println(String.join(",", winners) + "가 최종 우승하셨습니다.");
    }

    // 라운드별 이동결과 누적
    public static void roundRacingHistory(Map<Integer, Map<Car, Boolean>> roundHistory, int time) {
        Map<Car, Integer> result = new HashMap<Car, Integer>();
        for (int i = 1; i <= time; i++) {
            Map<Car, Boolean> roundCars = roundHistory.get(i);
            Iterator<Car> keys = roundCars.keySet().iterator();
            while (keys.hasNext()) {
                Car key = keys.next();
                Boolean carMoveYn = roundCars.get(key);

                int moveNum = carMoveYn ? 1 : 0;

                if (!result.containsKey(key)) {
                    result.put(key, moveNum);
                    continue;
                }
                result.put(key, result.get(key) + moveNum);
            }
        }

        Iterator<Car> resultKey = result.keySet().iterator();
        while (resultKey.hasNext()) {
            Car key = resultKey.next();
            System.out.print(key.getCarName() + " : ");
            for (int i = 0; i < result.get(key); i++) {
                System.out.print(PRINT_CAR_PISITION);
            }
            System.out.println();
        }
    }
}