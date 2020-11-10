package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CarController {
    private static final Random random = new Random();
    private static final int MAX_MOVING_BOUNDARY = 10;

    public CarList initCarList(String[] carNames) {
        List<Car> carList = Arrays.stream(carNames)
                .map(Car::from)
                .collect(Collectors.toList());

        return CarList.from(carList);
    }

    public CarList nextRound(CarList carList) {
        List<Car> cars = carList.getCarList();
        for(Car car : cars) {
            car.move(makeRandomValue());
        }
        return CarList.from(cars);
    }

    private int makeRandomValue() {
        return random.nextInt(MAX_MOVING_BOUNDARY);
    }

    public List<String> getWinner(CarList carList) {
        List<String> winners = new ArrayList<>();

        int winnerScore = getWinnerScore(carList);
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

    public int getWinnerScore(CarList carList) {
        int winnerScore = 0;
        for(Car car : carList.getCarList()) {
            winnerScore = Math.max(winnerScore, car.getCurrentPosition());
        }
        return winnerScore;
    }

}
