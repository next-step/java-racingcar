package step4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCarGame {

    private final List<RacingCar> racingCars;
    private final int tryCount;

    public RacingCarGame(List<RacingCar> racingCars, int tryCount) {
        this.racingCars = racingCars;
        this.tryCount = tryCount;
    }

    public void gameStart() {
        RacingGamePrinter.printGameResultMessage();

        IntStream.range(0, tryCount).forEach(i -> {
            allRacingCarMove();
            RacingGamePrinter.printRacingCarsPositionExpression(racingCars);
        });
    }

    private void allRacingCarMove() {
        racingCars.forEach(racingCar -> racingCar.move(new RacingCarMoveCondition()));
    }

    private static List<RacingCar> createRacingCars(String[] names) {
        validateEmpty(names);
        validateDuplicateName(names);

        return Arrays.stream(names)
            .map(RacingCar::new)
            .collect(Collectors.toList());
    }

    private static void validateEmpty(String[] names) {
        if (names == null || names.length == 0) {
            throw new RuntimeException("최소 하나 이상의 자동차 이름이 차필요합니다.");
        }
    }

    private static void validateDuplicateName(String[] names) {
        if (Arrays.stream(names).distinct().count() != names.length) {
            throw new RuntimeException("중복된 자동차 이름이 존재할 수 없습니다.");
        }
    }

    public static void main(String[] args) {
        int tryCount = RacingGameInitializer.initTryCount();
        String[] racingCarNames = RacingGameInitializer.initRacingCarNames();
        List<RacingCar> racingCars = createRacingCars(racingCarNames);
        RacingCarGame racingCarGame = new RacingCarGame(racingCars, tryCount);
        racingCarGame.gameStart();
    }
}
