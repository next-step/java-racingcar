package race.step4.domain;

import race.step4.model.Record;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarRacing {

    private final String[] players;
    private final int numTry;

    public CarRacing(String[] players, int numTry) {
        this.players = validatePlayersName(players);
        this.numTry = validatePositiveNum(numTry);
    }


    public List<List<Record>> carRacing(List<Car> carList, MoveStrategy randomMoveStrategy) {
        return IntStream.range(0, numTry)
                .mapToObj(i -> race(carList, randomMoveStrategy))
                .collect(Collectors.toList());
    }

    public List<Record> race(List<Car> carList, MoveStrategy randomMoveStrategy) {
        return carList.stream()
                .map(car -> {
                    car.tryMove(randomMoveStrategy);
                    return new Record(car.getPlayer(), car.getDistance());
                })
                .collect(Collectors.toList());
    }

    public List<Car> createCarList() {
        return Arrays.stream(players)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public String[] validatePlayersName(String[] players) {
        return Arrays.stream(players)
                .filter(s -> validatePlayer(s).length() < 5)
                .toArray(String[]::new);
    }

    public String validatePlayer(String player) {
        if (player.length() > 5) throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        return player;
    }

    public int validatePositiveNum(int value) {
        if (value <= 0) throw new IllegalArgumentException("0 이거나 음수는 허용되지 않습니다.");
        return value;
    }
}
