package step3.observers;

import step3.Car;
import step3.RacingGame;
import step3.interfaces.OutputInterface;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleRacingStatusView implements OutputInterface {
    public void output(RacingGame racingGame) {
        String outputString = racingGame.getCars().stream().map(Car::getLocation)
                .map(l -> Stream.generate(() -> "-").limit(l).collect(Collectors.joining()))
                .map(s -> s + "\n")
                .collect(Collectors.joining());

        if (racingGame.getCurrentTurn() == 0) {
            System.out.println("실행 결과");
        }

        System.out.println(outputString);
    }
}
