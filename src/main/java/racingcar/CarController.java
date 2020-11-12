package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CarController {
    private static final Random random = new Random();
    private static final int MAX_MOVING_BOUNDARY = 10;

    private CarList carList;
    private int tryCounts;
    private int round;

    public CarController(String[] carNames, int tryCounts) {
        this.tryCounts = tryCounts;
        initCarList(carNames);
    }

    public CarController(CarList carList) {
        this.carList = carList;
    }

    public CarController(int tryCounts, int round) {
        this.tryCounts = tryCounts;
        this.round = round;
    }

    public void initCarList(String[] carNames) {
        List<Car> cars = Arrays.stream(carNames)
                .map(Car::from)
                .collect(Collectors.toList());

        carList = CarList.from(cars);
    }

    public boolean isFinish() {
        return tryCounts == round;
    }

    public CarList nextRound() {
        round++;
        List<Car> cars = carList.getCarList();
        for(Car car : cars) {
            car.move(makeRandomValue());
        }
        return CarList.from(cars);
    }

    private int makeRandomValue() {
        return random.nextInt(MAX_MOVING_BOUNDARY);
    }

    public List<String> getWinner() {
        List<String> winners = new ArrayList<>();

        int winnerScore = getWinnerScore();
        for(Car car : carList.getCarList()) {
            getWinnerName(winnerScore, car, winners);
        }

        return winners;
    }

    public void getWinnerName(int winnerScore, Car car, List<String> winners) {
        if(winnerScore == car.getCurrentPosition()) {
            winners.add(car.getName());
        }
    }

    public int getWinnerScore() {
        int winnerScore = 0;
        for(Car car : carList.getCarList()) {
            winnerScore = Math.max(winnerScore, car.getCurrentPosition());
        }
        return winnerScore;
    }

    public CarList getCarList() {
        return carList;
    }

}
