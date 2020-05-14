package com.nextstep.racingcar.application;

import com.nextstep.racingcar.domain.car.CarFactory;
import com.nextstep.racingcar.domain.car.Cars;
import com.nextstep.racingcar.domain.car.MoveStrategy;
import com.nextstep.racingcar.domain.round.Round;
import com.nextstep.racingcar.domain.round.RoundResult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RacingGame {
    private int carNumber;
    private int roundNumber;
    private List<String> driverNames;
    private List<String> results = new ArrayList<>();
    private List<RoundResult> roundResults = new ArrayList<>();

    private RacingGame(int carNumber, int roundNumber, List<String> driverNames) {
        this.carNumber = carNumber;
        this.roundNumber = roundNumber;
        this.driverNames = driverNames;
    }

    public RacingGame(int carNumber, int roundNumber) {
        this(carNumber, roundNumber, null);
    }

    public RacingGame(List<String> driverNames, int roundNumber) {
        this(0, roundNumber, driverNames);
    }

    public void run(CarFactory carFactory, MoveStrategy moveStrategy) {
        Cars cars = Cars.createRandomCarsByNumber(carNumber, carFactory);

        IntStream.range(0, roundNumber).forEach(num -> {
            Round round = Round.newRound(cars);
            round.moveAll(moveStrategy);
            results.add(round.getTotalResult());
        });
    }

    public void runByDriversName(CarFactory carFactory, MoveStrategy moveStrategy) {
        Cars cars = Cars.createCarsByDriverNames(driverNames, carFactory);

        IntStream.range(0, roundNumber).forEach(num -> {
            Round round = Round.newRound(cars);
            round.moveAll(moveStrategy);
            // TODO: RoundResults 일급콜렉션 구현 후 되돌아오자
//            roundResults.add(round.getRoundResults());
        });
    }

    public List<String> getResults() {
        return this.results;
    }

    public RacingGameResult getRacingGameResult() {
        return RacingGameResult.create(roundResults);
    }
}
