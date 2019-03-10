package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        Input.input();
        RacingGame racingGame = new RacingGame(Input.getTimes());

        List<Car> cars = new ArrayList<>();
        for (int i = 1; i <= Input.getNumOfCars(); i++) {
            cars.add(new Car());
        }

        List<Car> carsFinishedRace = racingGame.start(cars, new RandomNumberGenerator());
        List<String> result = carsFinishedRace.stream().map(Car::getRacingPath).collect(Collectors.toList());
        Output.print(result);
    }
}
