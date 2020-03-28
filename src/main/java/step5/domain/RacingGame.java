package step5.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private static final int MOVE_COUNT_NUMBER = 0;

    private static final String DELIMITER_COMMA = ",";

    private int moveCount;
    private Cars cars;
    private List<Cars> moveCars;
    private String winnerNames;

    public RacingGame(int moveCount, String[] splitCarName) {
        validateMoveCount(moveCount);
        this.moveCount = moveCount;
        this.cars = new Cars(splitCarName);
    }

    public RacingGame(int moveCount, Cars cars) {
        this.moveCount = moveCount;
        this.cars = cars;
    }

    public void racingByRepeatCount() {
        List<Cars> moveCars = new ArrayList<>();
        for (int i = 0; i < moveCount; i++) {
            cars = racing();
            moveCars.add(cars);
        }
        this.moveCars = moveCars;
    }

    public List<String> getWinnerNames(List<Car> winners) {
        return winners.stream().
                map(Car::getName)
                      .collect(Collectors.toList());
    }

    public List<Car> winUsers() {
        return cars.getCars().stream().
                filter(car -> car.isSame(findMaxRacingResult()))
                   .collect(Collectors.toList());
    }

    public String findMaxRacingResult() {
        return cars.getCars().stream()
                   .max(Comparator.comparing(Car::getPosition))
                   .orElse(null)
                   .getPosition();
    }

    private Cars racing() {
        List<Car> resultCars = new ArrayList<>();
        for (Car car : cars.getCars()) {
            car.move();
            resultCars.add(car);
        }
        return new Cars(resultCars);
    }

    private void validateMoveCount(int moveCount) {
        if (moveCount <= MOVE_COUNT_NUMBER) {
            throw new IllegalArgumentException("움직이는 횟수는 최소 1번 이상이어야 합니다");
        }
    }


    public String getWinnerNames() {
        return  getWinnerNames(winUsers())
                .stream()
                .collect(Collectors.joining(DELIMITER_COMMA));
    }


    public List<Cars> getMoveCars() {
        return moveCars;
    }
}
