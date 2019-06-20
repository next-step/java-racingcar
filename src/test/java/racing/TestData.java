package racing;

import racing.common.RacingSettings;
import racing.domain.Car;
import racing.domain.Cars;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestData {
    public final static String WINNER_NAMES = "b,c";
    public final static Cars GAME_ENDED_CARS;
    public final static String DEFAULT_CAR_NAME = "a,b,c,d";
    public final static String MANY_CAR_NAME = "a,b,c,d,e,f,g,h,i,j";
    public final static String GAME_ENDED_CARS_NAME = DEFAULT_CAR_NAME;
    private final static int[] GAME_ENDED_CARS_POSITION = {1, 4, 4, 2};
    public final static int ONE_MOVED_POSITION = 1;
    public final static int DEFAULT_TIME = 10;
    public final static int ZERO_TIME = 0;
    
    static {
        final String SPLIT_REGEX = RacingSettings.CAR_NAME_SEPARATOR.getStr();
        String[] carNames = GAME_ENDED_CARS_NAME.split(SPLIT_REGEX);
        GAME_ENDED_CARS = new Cars.Builder(IntStream.range(0, carNames.length)
          .mapToObj(i -> new Car(carNames[i], GAME_ENDED_CARS_POSITION[i]))
          .collect(Collectors.toList())
        ).build();
    }
    
    public static List<Car> getNewDefaultCarsForTest() {
        String[] playerNames = DEFAULT_CAR_NAME.split(RacingSettings.CAR_NAME_SEPARATOR.getStr());
        return IntStream.range(0, playerNames.length)
          .mapToObj(i -> new Car(playerNames[i]))
          .collect(Collectors.toList());
    }
}
