package racing.service;

import racing.utils.RacingUtils;

import java.util.HashMap;

public class RacingCarService {

    private static final String RACING_SIGN = "-";

    public static HashMap<Integer, StringBuffer> initialRacingCar(int racingCar) {
        HashMap<Integer, StringBuffer> racingList = new HashMap<>();
        for (int i = 0; i < racingCar; i++) {
            racingList.put(i, new StringBuffer());
        }
        return racingList;
    }

    public static StringBuffer randomPlay(StringBuffer carMoves) {
        int randomNumber = RacingUtils.randomNumber();
        if (RacingUtils.compareNumbers(randomNumber)) {
            carMoves.append(RACING_SIGN);
        }
        return carMoves;

    }

    public static void race(HashMap<Integer, StringBuffer> carPlayList) {
        for (int i = 0; i < carPlayList.size(); i++) {
            StringBuffer carMoves = new StringBuffer(randomPlay(carPlayList.get(i)));
            carPlayList.put(i, carMoves);
            System.out.println(carMoves);
        }
        System.out.println();
    }


}
