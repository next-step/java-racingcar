package carRacing.domain;

import carRacing.dto.UserInput;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Game {

    private static final Random random = new Random();

    private final View view = new View();
    private final Judge judge = new Judge();

    public List<Car> race(List<Car> cars) {
        return cars.stream()
                .map(car -> car.raceOrStay(car, random.nextInt()))
                .collect(Collectors.toList());
    }

    public int runRace(UserInput userInput, List<Car> cars){
        int raceCount = 0;
        while (!judge.isGameOver(userInput)) {
            cars = race(cars);
            view.printScoreboard(cars);
            judge.recordTime();
            raceCount++;
        }
        return raceCount;
    }

}
