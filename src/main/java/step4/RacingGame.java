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

    private static final int MOVE_COUNT_NUMBER = 0;
    private static final int CAR_POSITIONS_SIZE = 0;

    public RacingGame() {
    }

    public RacingGame(int moveCount, List<Car> carPositions) {
        validateMoveCount(moveCount);
        validateCarPositions(carPositions);
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

    public List<String> getWinnerNames(List<Car> winners) {
        return winners.stream().
                flatMap(car -> Stream.of(car.getName()))
                      .collect(Collectors.toList());
    }

    public List<Car> winUsers() {
        String max = FindMaxRacingResult();
        return carPositions.stream().
                filter(carPosition -> max.equals(carPosition.getRacingResult()))
                           .collect(Collectors.toList());
    }

    public String FindMaxRacingResult() {
        return carPositions.stream()
                           .max(Comparator.comparing(Car::getRacingResult))
                           .get()
                           .getRacingResult();
    }

    private List<Car> racing() {
        List<Car> resultCars = new ArrayList<>();
        for (Car car : carPositions) {
            car.move();
            resultCars.add(car);
        }
        return resultCars;
    }

    private void validateMoveCount(int moveCount) {
        if (moveCount <= MOVE_COUNT_NUMBER) {
            throw new IllegalArgumentException("움직이는 횟수는 최소 1번 이상이어야 합니다");
        }
    }

    private void validateCarPositions(List<Car> carPositions) {
        if (carPositions.size() <= CAR_POSITIONS_SIZE) {
            throw new IllegalArgumentException("자동차의 개수는 최소 1대 이상이어야 합니다.");
        }
    }

    public void setWinnerNames() {
        List<String> winnerNames = getWinnerNames(winUsers());
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
