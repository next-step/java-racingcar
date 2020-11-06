package study.racing.view;

public class RacingInput {

    private final int countOfCar;
    private final int countOfRound;

    public RacingInput(int countOfCar, int countOfRound) {

        validateCountOfCar(countOfCar);
        validateCountOfRound(countOfRound);

        this.countOfCar = countOfCar;
        this.countOfRound = countOfRound;
    }

    private void validateCountOfCar(int countOfCar) {
        if (countOfCar <= 0) {
            throw new IllegalArgumentException("자동차 수는 0 보다 커야합니다.");
        }
    }

    private void validateCountOfRound(int countOfRound) {
        if (countOfRound <= 0) {
            throw new IllegalArgumentException("라운드 횟수는 0 보다 커야합니다.");
        }
    }

    public int getCountOfCar() {
        return countOfCar;
    }

    public int getCountOfRound() {
        return countOfRound;
    }
}
