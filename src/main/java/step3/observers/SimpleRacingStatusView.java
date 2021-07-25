package step3.observers;

import step3.Car;
import step3.RacingGame;
import step3.interfaces.OutputInterface;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleRacingStatusView implements OutputInterface {
    public void output(RacingGame racingGame) {
        final int firstTurn = 1;

        String outputString = racingGame.getCars().stream().map(Car::getLocation)
                .map(this::repeatDashBy)
                .map(s -> s + "\n")
                .collect(Collectors.joining());

        if (racingGame.getCurrentTurn() == firstTurn) {
            System.out.println("실행 결과");
        }

        System.out.println(outputString);
    }

    private String repeatDashBy(int n) {
        return Stream.generate(() -> "-").limit(n).collect(Collectors.joining());
    }
}
