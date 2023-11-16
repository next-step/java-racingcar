package step5.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberUtil {

    public static final int RANGE_OF_NUMBER = 10;

    public static List<Integer> createRandomNumbers(int numOfCars) {
        return IntStream.range(0, numOfCars)
            .mapToObj(i -> (int) (Math.random()* RANGE_OF_NUMBER))
            .collect(Collectors.toUnmodifiableList());
    }
}