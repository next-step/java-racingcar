package com.racingcar.model;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class RacingCarGame {

    private Integer countOfAttempt;
    private List<RacingCar> racingRacingCars;

    public RacingCarGame(List<String> racingCarNames, Integer countOfAttempt) {
        if (CollectionUtils.isEmpty(racingCarNames)) {
            throw new IllegalArgumentException("플레이할 자동차의 개수는 0개 이상입력해주세요.");
        }

        initRacingCarWithName(racingCarNames);
        this.countOfAttempt = countOfAttempt;
    }

    private void initRacingCarWithName(List<String> racingCarNames) {
        if (CollectionUtils.isEmpty(this.racingRacingCars)) {
            this.racingRacingCars = new ArrayList<>();
        }

        for (String racingCarName : racingCarNames) {
            RacingCar racingCar = new RacingCar(1, racingCarName);
            racingRacingCars.add(racingCar);
        }
    }

    public void playRacingGame() {
        for (RacingCar racingCar : this.racingRacingCars) {
            racingCar.movingRacingCar();
        }
    }

    public List<RacingCar> getRacingRacingCars() {
        return racingRacingCars;
    }

    public Integer getCountOfAttempt() {
        return countOfAttempt;
    }

    public List<RacingCar> extractWinner() {
        return CollectionUtils.emptyIfNull(this.racingRacingCars)
                .stream()
                .collect(Collectors.groupingBy(
                        RacingCar::getRacingStatus,
                        TreeMap::new,
                        toList()
                ))
                .lastEntry()
                .getValue();
    }
}
