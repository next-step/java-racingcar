package racing.service;

import racing.utils.RacingUtils;

public class RacingCarService {

    private static final String RACING_SIGN = "-";

    public static StringBuffer randomPlay(StringBuffer carMoves) {
        int randomNumber = RacingUtils.randomNumber();
        if (RacingUtils.compareNumbers(randomNumber)) {
            carMoves.append(RACING_SIGN);
        }
        return carMoves;

    }

}
