package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.Getter;

public class RacingGameInfo {
    @Getter
    private Rule rule;

    @Getter
    private Integer gameCount;

    @Getter
    private List<Car> cars = new ArrayList<>();

    private RacingGameInfo(Rule rule, Integer gameCount){
        this.rule = rule;
        this.gameCount = gameCount;
    }

    public RacingGameInfo(Rule rule, Integer gameCount, Integer carCount) {
        this(rule, gameCount);
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public RacingGameInfo(Rule rule, Integer gameCount, String carNames) {
        this(rule, gameCount);
        Arrays.stream(carNames.split(",")).map(String::trim)
            .map(Car::new)
            .forEach(cars::add);
    }
}
