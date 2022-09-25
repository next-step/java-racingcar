package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCarGame {

    private List<RacingCar> racingCars;
    private int tryCount;

    public RacingCarGame(int racingCarCount, int tryCount) {
        this.tryCount = tryCount;
        this.racingCars = createRacingCars(racingCarCount);
    }

    public void gameStart() {
        RacingGamePrinter.printGameResultMessage();

        for (int i = 0; i < tryCount; i++) {
            allRacingCarMove();
            RacingGamePrinter.printRacingCarsPositionExpression(racingCars);
        }
    }

    private void allRacingCarMove() {
        racingCars.forEach(racingCar -> racingCar.move(new RacingCarMoveCondition()));
    }

    private static List<RacingCar> createRacingCars(int initRacingCarCount) {
        return IntStream.range(0, initRacingCarCount)
            .mapToObj(i -> new RacingCar())
            .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int tryCount = RacingGameInitializer.initTryCount();
        int racingCarCount = RacingGameInitializer.initRacingCarCount();

        RacingCarGame racingCarGame = new RacingCarGame(racingCarCount, tryCount);
        racingCarGame.gameStart();
    }
}
