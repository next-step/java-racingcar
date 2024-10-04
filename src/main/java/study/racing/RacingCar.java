package study.racing;

import study.utils.NumberUtils;
import java.util.Map;

public class RacingCar {

    public static int goAndStop() {

        int randomNumber = NumberUtils.randomNumberUnder10();
        int forWord = 0;
        if(randomNumber >=4 ) {
            forWord++;
        }

        return forWord;
    }

    public static  Map<Integer, Integer> addCountForDash(int car, int moveCount, Map<Integer, Integer> map) {

        if(!map.containsKey(car)) {
            map.put(car, 0);

        }
        map.put(car, map.get(car) + moveCount);

        return map;
    }
}
