package racingCar;

public class RacingGame {
    private Cars cars;
    private int times;

    public RacingGame(int numbersOfCar, int times) {
        this.cars = new Cars(numbersOfCar);
        this.times = times;
    }

    // 시작 : 이동 횟수만큼 담는다.
    public GameResult start() {
        GameResult gameResult = new GameResult();
        for (int i = times; i > 0; i--) {
            gameResult.add(move());
        }
        return gameResult;
    }

    private Integer[] move() {
        return cars.move();
    }
}
