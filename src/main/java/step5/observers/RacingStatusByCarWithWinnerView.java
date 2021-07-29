package step5.observers;

import step5.Car;
import step5.CarName;
import step5.RacingGame;
import step5.interfaces.OutputInterface;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingStatusByCarWithWinnerView implements OutputInterface {

    @Override
    public void output(RacingGame racingGame) {
        final int FIRST_TURN = 1;
        final int LAST_TURN = getLastTurn(racingGame);

        String outputString = racingGame.getRacingEntry().getCars().stream()
                .map(car -> String.format("%s : %s\n", car.getCarName().getValue(), repeatDashBy(car.getLocation())))
                .collect(Collectors.joining());

        if (racingGame.getCurrentTurn() == FIRST_TURN) {
            System.out.println("실행 결과");
        }

        System.out.println(outputString);

        if (racingGame.getCurrentTurn() == LAST_TURN) {
            System.out.printf("%s 가 최종 우승했습니다.%n", getWinnerNames(racingGame));
        }
    }

    private String getWinnerNames(RacingGame racingGame) {
        return racingGame.getRacingEntry().findWinners().stream()
                .map(Car::getCarName)
                .map(CarName::getValue)
                .collect(Collectors.joining(", "));
    }

    private int getLastTurn(RacingGame racingGame) {
        return racingGame.getRacingGameConfiguration().getNumberOfTurns();
    }

    private String repeatDashBy(int n) {
        return Stream.generate(() -> "-")
                .limit(n)
                .collect(Collectors.joining());
    }
}
