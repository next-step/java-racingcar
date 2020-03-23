package step4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.sun.deploy.util.StringUtils;

public class RacingGame {

    private int moveCount;
    private List<Car> carPositions;
    private List<List<Car>> moveCarPositions;
    private String winnerNames;

    public RacingGame() {
    }

    public RacingGame(int moveCount, List<Car> carPositions) {
        this.moveCount = moveCount;
        this.carPositions = carPositions;
    }

    public void racingByRepeatCount() {
        List<List<Car>> moveCarPositions = new ArrayList<>();
        for (int i = 0; i < moveCount; i++) {
            carPositions = racing();
            moveCarPositions.add(carPositions);
        }
        this.moveCarPositions = moveCarPositions;
    }

    public List<Car> racing() {
        List<Car> resultCars = new ArrayList<>();
        for (Car car : carPositions) {
            car.move();
            resultCars.add(car);
        }
        return resultCars;
    }

    public List<String> getWinnerNames(List<Car> winners) {
        return winners.stream().flatMap(car -> Stream.of(car.getName())).collect(
                Collectors.toList());
    }

    public List<Car> winUsers(String max) {
        return carPositions.stream().filter(
                carPosition -> max.equals(carPosition.getRacingResult())).collect(
                Collectors.toList());
    }

    public String maxRacingResult() {
        return carPositions.stream().max(Comparator.comparing(Car::getRacingResult)).get()
                           .getRacingResult();
    }

    public void setWinnerNames() {
        List<String> winnerNames = getWinnerNames(winUsers(maxRacingResult()));
        this.winnerNames = StringUtils.join(winnerNames, ",");
    }

    public String getWinnerNames() {
        return winnerNames;
    }

    public List<Car> getCarPositions() {
        return carPositions;
    }

    public List<List<Car>> getMoveCarPositions() {
        return moveCarPositions;
    }
}
