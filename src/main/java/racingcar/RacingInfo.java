package racingcar;

import lombok.Data;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
public class RacingInfo {
    private int numOfCars;
    private int numOfTries;
    private ArrayList<CarInfo> carInfos;

    public RacingInfo(UserInput userInput) {
        this.numOfCars = userInput.getNumOfCarsByInt();
        this.numOfTries = userInput.getNumOfTriesByInt();
        carInfos = initCarInfos(userInput.getNumOfCarsByInt());
    }

    private ArrayList<CarInfo> initCarInfos(int num) {
        return IntStream.range(0, num)
                .mapToObj(i -> new CarInfo())
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
