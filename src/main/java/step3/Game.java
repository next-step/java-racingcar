package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Game {

    private final Long time;
    private final List<Car> cars;

    public Game(Long time, List<Car> cars) {
        this.time = time;
        this.cars = cars;
    }

    public static Game of(RuleDto ruleDto) {
        InputValidator.isNull(ruleDto.getCount());
        InputValidator.isNull(ruleDto.getTime());

        List<Car> cars = LongStream.range(0, ruleDto.getCount())
                .mapToObj(Car::new)
                .collect(Collectors.toList());

        return new Game(ruleDto.getTime(), cars);
    }
}
