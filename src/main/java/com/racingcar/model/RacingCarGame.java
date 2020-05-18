package com.racingcar.model;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class RacingCarGame {

    private Integer countOfAttempt;
    private List<RacingCar> racingCars;

    public RacingCarGame(List<String> racingCarNames, Integer countOfAttempt) {
        if (CollectionUtils.isEmpty(racingCarNames)) {
            throw new IllegalArgumentException("플레이할 자동차의 개수는 0개 이상입력해주세요.");
        }


        this.racingCars = new ArrayList<>();
        this.countOfAttempt = countOfAttempt;
        initRacingCarWithName(racingCarNames);
    }

    private void initRacingCarWithName(List<String> racingCarNames) {
        for (String racingCarName : racingCarNames) {
            RacingCar racingCar = new RacingCar(1, racingCarName);
            racingCars.add(racingCar);
        }
    }

    public void playRacingGame() {
        for (RacingCar racingCar : this.racingCars) {
            racingCar.movingRacingCar();
        }
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public Integer getCountOfAttempt() {
        return countOfAttempt;
    }

    public List<RacingCar> extractWinner() {
        return CollectionUtils.emptyIfNull(this.racingCars)
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
