package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import racingcar.Constant;
import racingcar.util.PrintUtils;
import racingcar.util.RandomUtils;

@NoArgsConstructor
@AllArgsConstructor
public class Game {

    private static final int RANDOM_START = 0;
    private static final int RANDOM_END = 9;
    private int gameCnt;
    private List<Car> carInfos;

    public List<Car> getWinner() {
        return carInfos
            .stream()
            .max((a, b) -> Integer.compare(a.getPosition(), b.getPosition()))
            .map(winnerThreshold -> carInfos
                .stream()
                .filter(car -> winnerThreshold.getPosition() == car.getPosition())
                .collect(Collectors.toList())
            )
            .get();
    }

    public void play() {
        PrintUtils.printExecutionResult();
        Stream.iterate(0, i -> i + 1)
            .limit(gameCnt)
            .forEach(i -> {
                carInfos.stream()
                    .forEach(car -> checkMove(car, RandomUtils.nextInt(RANDOM_START, RANDOM_END)));
                PrintUtils.printCarStep(carInfos);
            });
    }

    public void checkMove(Car car, int randomNum) {
        if (randomNum >= Constant.MOVE_THRESHOLD) {
            car.updatePosition();
        }
    }
}
