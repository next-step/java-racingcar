package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingTrac {

    public static RacingCar[] getGameResult(int countOfRacingCar, int countOfRacing) {
        RacingCar[] gameResult = new RacingCar[countOfRacingCar];

        for(int i=0;i<countOfRacingCar;i++) {
            RacingCar racingcar = new RacingCar();
            racingcar.racing(countOfRacing);
            gameResult[i] = racingcar;
        }
        return gameResult;
    }
}
