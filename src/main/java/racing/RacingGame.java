package racing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingGame {

    private int totalRound;
    private List<Car> cars;
    private Random random = new Random();

    static final int RANDOM_BOUND = 10;


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

        int winPosition = getWinPosition();
        return filteringWinners(winPosition);
    }

    private void moveWholeCar() {
        for (Car car : cars) {
            int randomNum = random.nextInt(RANDOM_BOUND);
            car.move(randomNum);
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
