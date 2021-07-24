package step3.observers;

import step3.Car;
import step3.RacingGame;
import step3.interfaces.OutputInterface;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleRacingStatus implements OutputInterface {
    public void output(RacingGame racingGame) {
        String outputString = racingGame.getCars().stream().map(Car::getLocation)
                .map(l -> Stream.generate(() -> "-").limit(l).collect(Collectors.joining()))
                .map(s -> s + "\n")
                .collect(Collectors.joining());

        System.out.println(outputString);
    }
}
