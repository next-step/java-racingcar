package racing;

import racing.domain.Car;
import racing.domain.Cars;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestData {
    public static String WINNER_NAMES = "b,c";
    public static Cars GAME_ENDED_CARS;
    public static Cars PLAYERS;
    public static String DEFAULT_CAR_NAME = "a,b,c,d";
    public static String MANY_CAR_NAME = "a,b,c,d,e,f,g,h,i,j";
    public static String GAME_ENDED_CARS_NAME = DEFAULT_CAR_NAME;
    private static int[] GAME_ENDED_CARS_POSITION = {1, 4, 4, 2};
    public static int ONE_MOVED_POSITION = 1;
    public static int DEFAULT_TIME = 10;
    public static int ZERO_TIME = 0;
    
    static {
        setGameEndedCars();
    }
    
    private static void setGameEndedCars() {
        final String SPLIT_REGEX = ",";
        String[] carNames = GAME_ENDED_CARS_NAME.split(SPLIT_REGEX);
        GAME_ENDED_CARS = new Cars(IntStream.range(0, carNames.length)
            .mapToObj(i -> new Car(carNames[i], GAME_ENDED_CARS_POSITION[i]))
            .collect(Collectors.toList())
        );
        String[] playerNames = DEFAULT_CAR_NAME.split(SPLIT_REGEX);
        PLAYERS = new Cars(IntStream.range(0, playerNames.length)
            .mapToObj(i -> new Car(playerNames[i], 0))
            .collect(Collectors.toList()));
    }
}
