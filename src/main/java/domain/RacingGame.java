package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 레이싱게임에 대한 클래스
 */
public class RacingGame {

    public Cars cars;
    public Winner winner;

    public RacingGame(Cars cars) {
        this.cars = cars;
    }

    public RacingGame(String[] name) {
        List<Car> carList = Arrays.stream(name)
            .map(Car::new)
            .collect(Collectors.toList());
        this.cars = new Cars(carList);
    }

    /**
     * 게임에 대한 우승자 찾기
     */
    public void findWinner() {
        Position position = this.cars.findMaxPosition();
        List<Car> winners = cars.cars.stream()
            .filter(car -> car.position.equals(position))
            .collect(Collectors.toList());
        this.winner = new Winner(winners);
    }

    /**
     * 게임 진행 결과를 slice해서 담음
     */
    public String playResult(int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            cars.moveAll();
            sb.append(cars.printCarPositionAll()).append("\n");
        }
        return sb.toString();
    }
}
