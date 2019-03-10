package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        Input.input();
        RacingGame racingGame = new RacingGame(Input.getTimes());

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < Input.getNames().length; i++) {
            cars.add(new Car(Input.getNames()[i]));
        }

        List<Car> carsFinishedRace = racingGame.start(cars, new RandomNumberGenerator());
        Output.print(carsFinishedRace);

        Referee referee = new Referee();
        List<Car> winners = referee.getWinners(carsFinishedRace);
        Output.printWinner(winners);
    }
}
