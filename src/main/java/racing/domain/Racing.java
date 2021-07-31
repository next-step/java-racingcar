package racing.domain;

import racing.dto.RoundResult;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {

    private static final int MIN_ROUND = 1;
    private static final int MAX_ROUND = 10;

    private int totalRound;
    private int nowRound;
    private List<Car> cars;
    private NumberGenerator numberGenerator;

    public Racing(String names, int moveCount, NumberGenerator numberGenerator) {
        validateRound(moveCount);
        this.totalRound = moveCount;
        this.nowRound = 0;
        this.cars = Arrays.stream(names.split(",")).map(Car::new).collect(Collectors.toList());
        this.numberGenerator = numberGenerator;
    }

    private void validateRound(int moveCount) {
        if (moveCount < MIN_ROUND || moveCount > MAX_ROUND) {
            throw new IllegalArgumentException("이동 횟수는 " + MAX_ROUND + "이하의 자연수만 가능합니다.");
        }
    }

    public boolean isEnd() {
        return nowRound == totalRound;
    }

    public void play() {
        this.nowRound++;
        for (Car car : cars) {
            car.move(numberGenerator.generate());
        }
    }

    public RoundResult getRoundResult() {
        return new RoundResult(cars, findWinners());
    }

    private List<Car> findWinners() {
        int maxPosition = cars.stream().max(Comparator.comparingInt(Car::getNowPosition)).get().getNowPosition();

        return cars.stream()
                .filter(car -> car.getNowPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
