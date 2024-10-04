package step3;

public class Game {

    private int[][] gameResults;
    private Car[] cars;

    public void play(int carCount, int gameCount) {

        gameResults = new int[gameCount][carCount];

        makeRacingCars(carCount);

        for (int i = 0; i < gameCount; i++) {
            moveAndSaveResult(carCount, i);
        }

    }

    private void moveAndSaveResult(int carCount, int i) {
        for (int j = 0; j < carCount; j++) {
            Car car = cars[j];
            car.move();
            gameResults[i][j] = car.showDistance();
        }
    }

    public int[][] showGameResult() {
        return gameResults;
    }

    private void makeRacingCars(int carCount) {
        cars = new Car[carCount];
        for (int i = 0; i < carCount; i++) {
            Car car = new Car();
            cars[i] = car;
        }
    }
}
