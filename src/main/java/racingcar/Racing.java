package racingcar;

import lombok.Data;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
public class Racing {
    private final int numOfCars;
    private final int numOfTries;
    private ArrayList<Car> cars;
    private final int threshold;

    public Racing(UserInput userInput, int threshold) {
        this.numOfCars = userInput.numOfCarsByInt();
        this.numOfTries = userInput.numOfTriesByInt();
        cars = initCarInfos(userInput.numOfCarsByInt());
        this.threshold = threshold;
    }

    private ArrayList<Car> initCarInfos(int num) {
        return IntStream.range(0, num)
                .mapToObj(i -> new Car())
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
