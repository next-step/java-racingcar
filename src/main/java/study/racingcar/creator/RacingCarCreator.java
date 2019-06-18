package study.racingcar.creator;

import study.racingcar.strategy.RandomMovableStrategy;
import study.racingcar.model.Car;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * Created by wyparks2@gmail.com on 2019-06-17
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class RacingCarCreator {
    private RacingCarCreator() {
    }

    public static List<Car> create(int count) {
        return IntStream.range(0, count)
                .boxed()
                .map(index -> new Car("자동차 - " + index, new RandomMovableStrategy()))
                .collect(toList());
    }
}
