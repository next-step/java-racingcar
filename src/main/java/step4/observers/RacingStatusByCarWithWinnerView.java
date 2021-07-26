package step4.observers;

import step4.Car;
import step4.RacingGame;
import step4.interfaces.OutputInterface;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingStatusByCarWithWinnerView implements OutputInterface {

    @Override
    public void output(RacingGame racingGame) {
        final int FIRST_TURN = 1;
        final int LAST_TURN = getLastTurn(racingGame);

        String outputString = racingGame.getRacingEntry().getCars().stream()
                .map(car -> String.format("%s : %s\n", car.getName(), repeatDashBy(car.getLocation())))
                .collect(Collectors.joining());

        if (racingGame.getCurrentTurn() == FIRST_TURN) {
            System.out.println("실행 결과");
        }

        System.out.println(outputString);

        if (racingGame.getCurrentTurn() == LAST_TURN) {
            String winnerNames = racingGame.getRacingEntry().findWinners().stream()
                    .map(Car::getName)
                    .collect(Collectors.joining(", "));

            System.out.printf("%s 가 최종 우승했습니다.%n", winnerNames);
        }
    }

    private int getLastTurn(RacingGame racingGame) {
        return racingGame.getRacingGameConfiguration().getNumberOfTurns();
    }

    private String repeatDashBy(int n) {
        return Stream.generate(() -> "-").limit(n).collect(Collectors.joining());
    }
}
