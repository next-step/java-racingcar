package Car;


import java.util.*;

public class RacingCar {
    private List<Car> cars;
    private List<List<Integer>> gameResults;
    private int carCount;
    private int gameCount;

    public List<Car> getCars() {
        return cars;
    }

    public int getCarCount() {
        return carCount;
    }

    public int getGameCount() {
        return gameCount;
    }

    public List<List<Integer>> getGameResults() {
        return gameResults;
    }

    public RacingCar(int carCount, int gameCount) {
        validate(carCount, gameCount);
        this.carCount = carCount;
        this.gameCount = gameCount;
        gameResults = new ArrayList<>();
        cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public void gameStart() {
        saveResult();
        for (int i = 1; i < gameCount; i++) {
            cars.stream()
                    .forEach(car -> car.move());
            saveResult();
        }
    }

    private void saveResult() {
        List<Integer> result = new ArrayList<>();
        cars.stream()
                .forEach(car -> result.add(car.getMoveCount()));
        gameResults.add(result);
    }

    private void validate(int carCount, int gameCount) {
        if (carCount <= 0 || gameCount <= 0) {
            throw new IllegalArgumentException("0보다 큰 값을 입력해주세요.");
        }
    }


}
