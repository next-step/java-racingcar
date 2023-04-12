package racingcar;

import lombok.Data;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
public class Racing {
    private int numOfCars;
    private int numOfTries;
    private ArrayList<Car> cars;

    public Racing(UserInput userInput) {
        this.numOfCars = userInput.getNumOfCarsByInt();
        this.numOfTries = userInput.getNumOfTriesByInt();
        cars = initCarInfos(userInput.getNumOfCarsByInt());
    }

    private ArrayList<Car> initCarInfos(int num) {
        return IntStream.range(0, num)
                .mapToObj(i -> new Car())
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
