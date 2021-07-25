package step4.observers;

import step4.Car;
import step4.RacingGame;
import step4.interfaces.OutputInterface;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingStatusWithCarNameView implements OutputInterface {

    @Override
    public void output(RacingGame racingGame) {
        final int FIRST_TURN = 1;

        String outputString = racingGame.getCars().stream()
                .map(car -> String.format("%s : %s\n", car.getName(), repeatDashBy(car.getLocation())))
                .collect(Collectors.joining());

        if (racingGame.getCurrentTurn() == FIRST_TURN) {
            System.out.println("실행 결과");
        }

        System.out.println(outputString);
    }

    private String repeatDashBy(int n) {
        return Stream.generate(() -> "-").limit(n).collect(Collectors.joining());
    }
}
