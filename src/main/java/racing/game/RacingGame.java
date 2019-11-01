package racing.game;

import racing.Strategy.RandomMoveStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {


    private int totalRound;
    private List<Car> cars;


    public RacingGame(String inputName, int totalRound) {
        this.totalRound = totalRound;
        cars = new ArrayList<>();

        String[] carNames = inputName.split(",");
        int carNum = carNames.length;

        for (int i = 0; i < carNum; i++) {
            cars.add(new Car(carNames[i]));
        }
    }

    public RacingGame(List<Car> cars, int totalRound) {
        this.totalRound = totalRound;
        this.cars = cars;
    }

    public List<Car> doGame() {
        for (int i = 0; i < totalRound; i++) {
            moveWholeCar();
        }
        return cars;
    }

    public List<String> getWinner() {
        return filteringWinners(getWinPosition());
    }

    private void moveWholeCar() {
        for (Car car : cars) {
            car.move(new RandomMoveStrategy());
        }
    }

    private int getWinPosition() {
        int winPosition = 0;
        for (Car car : cars) {
            winPosition = Math.max(winPosition, car.getLatestPosition());
        }
        return winPosition;
    }

    private List<String> filteringWinners(int winPosition) {
        List<String> winners = cars.stream()
                .filter(car -> car.getLatestPosition() == winPosition)
                .map(car -> car.getName())
                .collect(Collectors.toList());

        return winners;
    }

}
