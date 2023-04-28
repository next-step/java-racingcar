package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Racing {
    private final int numOfTries;
    private ArrayList<Car> cars;
    private final int threshold;

    public Racing(UserInput userInput, int threshold) {
        this.numOfTries = userInput.numOfTriesByInt();
        cars = initCarInfos(userInput.numOfCarsByInt(), userInput.carNames());
        this.threshold = threshold;
    }

    private ArrayList<Car> initCarInfos(int num, String[] carNames) {
        return IntStream.range(0, num)
                .mapToObj(i -> new Car(carNames[i]))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public ArrayList<Car> cars() {
        return cars;
    }

    public int numOfTries() {
        return numOfTries;
    }

    public int threshold() {
        return threshold;
    }

    public boolean containsAllCarNames(String[] carNames) {
        return getCarNames().equals(Arrays.asList(carNames));
    }

    public boolean hasEqualNumOfTries(String numOfTries) {
        return this.numOfTries == Integer.parseInt(numOfTries);
    }

    private ArrayList<String> getCarNames() {
        return cars.stream()
                .map(Car::name)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
