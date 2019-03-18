package domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGameInfo {
    @Getter
    private Rule rule;

    @Setter
    @Getter
    private Integer gameCount;

    @Getter
    private List<Car> cars = new ArrayList<>();

    private RacingGameInfo(Rule rule, Integer gameCount){
        this.rule = rule;
        this.gameCount = gameCount;
    }

    public RacingGameInfo(Rule rule, Integer gameCount, List<String> carNames) {
        this(rule, gameCount);
        carNames.stream()
            .map(Car::new)
            .forEach(cars::add);
    }
}
