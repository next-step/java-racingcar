package step5.domain;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import step5.util.StringUtil;
import step5.view.PrintRacingGame;

public class RacingGame {
    private static final int RANDOM_VALUE = 10;
    private static final String SEPROATOR_VALUE = ", ";

    private List<Car> cars;
    private Random random;
    private int reps;

    public RacingGame(List<Car> carList) {
        this(carList,0,null);
    }

    public RacingGame(List<Car> carList, int reps, Random random) {
        this.cars = carList;
        this.reps = reps;
        this.random = random;
    }

    public void racing() {
        for (int i = 1; i <= reps; i++) {
            runOrStopWithRandom();
            PrintRacingGame.printReps(i);
            PrintRacingGame.printCars(cars);
            PrintRacingGame.printEnter();
        }
    }

    public void runOrStopWithRandom() {
        cars.stream()
                .forEach(car -> car.go(random.nextInt(RANDOM_VALUE)));
    }


    public int getMaxLocationWithList() {
        return cars.stream()
                .max(Comparator.comparing(Car::getLocation))
                .map(Car::getLocation)
                .get();
    }

    public String getWinner() {
        int max = getMaxLocationWithList();
        return cars.stream()
                .filter(car -> !StringUtil.isEmpty(car.winner(max)))
                .map(car -> car.winner(max))
                .collect(Collectors.joining(SEPROATOR_VALUE));
    }
}