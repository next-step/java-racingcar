package com.nextstep.racingcar.application;

import com.nextstep.racingcar.domain.car.CarFactory;
import com.nextstep.racingcar.domain.car.Cars;
import com.nextstep.racingcar.domain.round.Round;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RacingGame {
    private int carNumber;
    private int roundNumber;
    private List<String> results = new ArrayList<>();

    public RacingGame(int carNumber, int roundNumber) {
        this.carNumber = carNumber;
        this.roundNumber = roundNumber;
    }

    public void run(CarFactory carFactory) {
        Cars cars = Cars.createRandomCarsByNumber(carNumber, carFactory);

        IntStream.range(0, roundNumber).forEach(num -> {
            Round round = Round.newRound(cars);
            round.moveAll();
            results.add(round.getTotalResult());
        });
    }

    public List<String> checkResults() {
        return this.results;
    }
}
