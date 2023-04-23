package racingcar;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Getter
@Setter
public class Racing {
    private final int numOfTries;
    private ArrayList<Car> cars;
    private final int threshold;

    public Racing(UserInput userInput, int threshold) {
        this.numOfTries = userInput.numOfTriesByInt();
        cars = initCarInfos(userInput.numOfCarsByInt(), userInput.getCarNames());
        this.threshold = threshold;
    }

    private ArrayList<Car> initCarInfos(int num, String[] carNames) {
        return IntStream.range(0, num)
                .mapToObj(i -> new Car(carNames[i]))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<String> getCarNames() {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
