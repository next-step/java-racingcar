package racing.racingcar;

import java.util.stream.Stream;

public class RacingTrac {

    public static RacingCar[] getGameResult(int countOfRacingCar, int countOfRacing) {

        Stream<RacingCar> gameResult = Stream.generate(() -> new RacingCar(countOfRacing)).limit(countOfRacingCar);
        return gameResult.toArray( size -> new RacingCar[size]);
    }
}
