package racingcar;

public class RacingGame {
    public static void race(int carNumber, int moveNumber) {
        validateMoveNumber(moveNumber);
        RacingCars cars = RacingCars.create(carNumber);
        for (int i = 0; i < moveNumber; i++) {
            cars.moving();
            cars.print();
        }
    }

    private static void validateMoveNumber(int moveNumber) {
        if (moveNumber < 0) {
            throw new IllegalArgumentException("정수값만 입력가능합니다.");
        }
    }
}
