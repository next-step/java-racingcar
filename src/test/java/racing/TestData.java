package racing;

import racing.common.Cars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestData {
    public static Cars GAME_ENDED_CARS;
    public static String GAME_ENDED_CARS_NAME = "a,b,c,d";
    private static int[] GAME_ENDED_CARS_POSITION = {1, 4, 4, 2};
    public static List<String> WINNER_NAMES = Arrays.asList("b", "c");
    
    
    static {
        setGameEndedCars();
    }
    
    private static void setGameEndedCars() {
        final String SPLIT_REGEX = ",";
        String[] carNames = GAME_ENDED_CARS_NAME.split(SPLIT_REGEX);
        GAME_ENDED_CARS = new Cars(
          IntStream.range(0, carNames.length)
            .mapToObj(i -> new Car(carNames[i], GAME_ENDED_CARS_POSITION[i]))
            .collect(Collectors.toList())
        );
    }
}
