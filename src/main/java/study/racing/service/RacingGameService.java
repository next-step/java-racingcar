package study.racing.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import study.racing.model.Result;
import study.racing.model.car.RacingCars;
import study.racing.model.rule.Rule;

public class RacingGameService {

    private final Rule rule;

    public RacingGameService(Rule rule) {
        this.rule = rule;
    }

    public List<Result> race(int carCount, int tryCount) {
        List<Result> results = new ArrayList<>();
        RacingCars racingCars = new RacingCars(carCount);
        for (int i = 0; i < tryCount; i++) {
            racingCars.raceAll(rule);
            results.add(new Result(racingCars.result()));
        }
        return Collections.unmodifiableList(results);
    }
}
