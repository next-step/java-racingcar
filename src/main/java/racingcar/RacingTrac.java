package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingTrac {


    public static void main(String[] args) {
        RacingTrac.getGameResult(3, 2);
    }
    public static RacingCar[] getGameResult(int countOfRacingCar, int countOfRacing) {
        RacingCar[] gameResult = new RacingCar[countOfRacingCar];

        Arrays.stream(gameResult).forEach(
                racingCar -> RacingCar.racing(countOfRacing)
        );



        System.out.println(Arrays.asList(gameResult));
        return gameResult;
    }
}
